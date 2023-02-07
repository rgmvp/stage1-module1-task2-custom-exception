package com.epam.mjc;

class CustomException extends IllegalArgumentException {
  public CustomException(String message) {
    super("Could not find student with ID {id}");
  }
}


public class StudentManager {

  private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

  public Student find(long studentID) {
    try {
      return Student.getValueOf(studentID);
    }
    catch(IllegalArgumentException e){
      throw new CustomException("Could not find student with ID "+ studentID);
    }
  }

  public static void main(String[] args) {
    StudentManager manager = new StudentManager();

    for (int i = 0; i < IDs.length; i++) {
      Student student = manager.find(IDs[i]);
      System.out.println("Student name " + student.getName());
    }

  }
}