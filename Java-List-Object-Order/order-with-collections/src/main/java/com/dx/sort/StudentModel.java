package com.dx.sort;

public class StudentModel {
    private Long id;
    private String name;
    private Integer age;
    private GradeModel gradeModel;
    private ClassModel classModel;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, Integer age, GradeModel gradeModel, ClassModel classModel) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gradeModel = gradeModel;
        this.classModel = classModel;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the classModel
     */
    public ClassModel getClassModel() {
        return classModel;
    }

    /**
     * @param classModel the classModel to set
     */
    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }

    /**
     * @return the gradeModel
     */
    public GradeModel getGradeModel() {
        return gradeModel;
    }

    /**
     * @param gradeModel the gradeModel to set
     */
    public void setGradeModel(GradeModel gradeModel) {
        this.gradeModel = gradeModel;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gradeModel=" + gradeModel +
                ", classModel=" + classModel +
                '}';
    }
}
