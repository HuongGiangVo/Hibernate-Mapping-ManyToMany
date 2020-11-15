package hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class AddCoursesForStudents {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Instructor.class)
												.addAnnotatedClass(InstructorDetail.class)
												.addAnnotatedClass(Course.class)
												.addAnnotatedClass(Review.class)
												.addAnnotatedClass(Student.class)
												.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			
			
			//start transaction
			session.beginTransaction();
			//get the student from database
			/*int studentId=105;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("The courses of student " + tempStudent.getCourses());*/
			//create more courses
			/*Course c1 = new Course("PHP");
			Course c2 = new Course("Python");
			//add student to courses
			c1.addStudent(tempStudent);
			c2.addStudent(tempStudent);
			//save the courses
			System.out.println("\nSaving the courses");
			session.save(c1);
			session.save(c2);*/
			//commit transaction
			//Delete course of student
			/*int courseId = 14;
			Course tempCourse = session.get(Course.class, courseId);
			System.out.println("\nDeleting the courses: "+tempCourse);
			session.delete(tempCourse);*/
			
			int studentId=105;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("\nDeleting the student: "+tempStudent);
			session.delete(tempStudent);
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally{
			session.close();
			factory.close();
			
		}

	}

}
