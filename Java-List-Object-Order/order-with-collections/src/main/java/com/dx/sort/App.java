package com.dx.sort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GradeModel gradeModel1 = new GradeModel(1, "一年级", 1);
        GradeModel gradeModel2 = new GradeModel(2, "二年级", 2);
        GradeModel gradeModel3 = new GradeModel(3, "三年级", 3);
        GradeModel gradeModel4 = new GradeModel(4, "四年级", 4);
        GradeModel gradeModel5 = new GradeModel(5, "五年级", 5);
        GradeModel gradeModel6 = new GradeModel(6, "六年级", 6);

        ClassModel classModel1 = new ClassModel(1, "一班", 1);
        ClassModel classModel2 = new ClassModel(1, "二班", 2);
        ClassModel classModel3 = new ClassModel(1, "三班", 3);
        ClassModel classModel4 = new ClassModel(1, "四班", 4);


        List<StudentModel> studentList = new ArrayList<>();
        studentList.add(new StudentModel(1000000L, "张三1", 7, gradeModel2, classModel1));
        studentList.add(new StudentModel(1000001L, "李四2", 7, gradeModel2, classModel1));
        studentList.add(new StudentModel(1000002L, "王五3", 7, gradeModel2, classModel1));
        studentList.add(new StudentModel(1000003L, "angle", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000004L, "Ant", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000005L, "Tom", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000006L, "Judy", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000007L, "Anna", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000008L, "Dav", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000009L, "Tommy", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000010L, "Null1", 6, gradeModel1, null));
        studentList.add(new StudentModel(1000011L, "Null2", 6, null, null));
        studentList.add(new StudentModel(1000012L, null, 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000013L, "王五", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000014L, "李四", 6, gradeModel1, classModel1));
        studentList.add(new StudentModel(1000015L, "张三", 6, gradeModel1, classModel1));
        studentList.add(null);

        Comparator<StudentModel> orderByGradeAllowNullAsc = Comparator.nullsLast(Comparator.comparing(StudentModel::getGradeModel, Comparator.nullsLast(Comparator.comparing(GradeModel::getWeight))));
        Comparator<StudentModel> orderByClassAllowNullAsc = Comparator.nullsLast(Comparator.comparing(StudentModel::getClassModel, Comparator.nullsLast(Comparator.comparing(ClassModel::getWeight))));
        // 中文也需要排序
        Comparator<StudentModel> orderByNameAllowNameNullDesc = Comparator.comparing(StudentModel::getName, Comparator.nullsFirst(Collator.getInstance(java.util.Locale.CHINA))).reversed();
        Comparator<StudentModel> orderByNameAllowNameNullAndAllowStudentNullDesc = Comparator.nullsLast(orderByNameAllowNameNullDesc);
        // 要求元素必须实现Comparable接口，这里因为Student未实现Comparable<T>，因此编译时就会报红。
//         Collections.sort(studentList, Comparator.naturalOrder()); // 升序
//         studentList.sort(Comparator.naturalOrder()); // 升序
//         studentList.stream().sorted(Comparator.reverseOrder()); // 降序

//         Collections.sort(studentList, orderByGradeAllowNullAsc.thenComparing(orderByClassAllowNullAsc).thenComparing(orderByNameAllowNameNullAndAllowStudentNullDesc));
//         for(StudentModel student:studentList){
//           System.out.println(student);
//         }

//         studentList.sort(orderByGradeAllowNullAsc.thenComparing(orderByClassAllowNullAsc).thenComparing(orderByNameAllowNameNullAndAllowStudentNullDesc));
//         for(StudentModel student:studentList){
//           System.out.println(student);
//         }

        studentList.stream().sorted(orderByGradeAllowNullAsc.thenComparing(orderByClassAllowNullAsc).thenComparing(orderByNameAllowNameNullAndAllowStudentNullDesc)).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("Hello World!");
    }
}
