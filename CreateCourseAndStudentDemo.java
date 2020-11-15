package hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			//create a course
			Course tempCourse = new Course("Java");
			
		
			System.out.println("\nSaving the course");
			
			session.save(tempCourse);
			System.out.println("Save the course: " + tempCourse);
			
			Student s1 = new Student("John", "Doe", "john@liff.com");
			Student s2 = new Student("Tana", "Doe", "tana@liff.com");
			
			//add students to course
			tempCourse.addStudent(s1);
			tempCourse.addStudent(s2);
			session.save(s1);
			session.save(s2);
			System.out.println("\nSaved Students: " + tempCourse.getStudents());			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally{
			session.close();
			factory.close();
			
		}

	}

}
