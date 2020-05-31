package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	Course mockCourse = new Course("Course1", "Spring", "10",
			Arrays.asList("Learn Maven", "Import Project", "First Example",
					"Second Example"));

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 \",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";


	@Test
	public void getAllStudents() throws Exception{

		List<Student> mockStudent =new ArrayList();
		mockStudent.add(new Student(101,"Test","Description", Arrays.asList(mockCourse)));

		
		Mockito.when(
					studentService.retrieveAllStudents()
				).thenReturn(mockStudent);
		
		RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/students/getAllStudnets").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result= mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		String expected ="[{\"id\":101,\"name\":\"Test\",\"description\":\"Description\"}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				studentService.retrieveCourse(Mockito.anyInt(),
						Mockito.anyString())).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/students/101/courses/Course1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().toString());
		String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10\"}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void getAllCourses() throws Exception{
		Course mockCourse = new Course("1", "Smallest Number", "10",
				Arrays.asList("1", "2", "3", "4"));
		List<Course> courseList= new ArrayList<>();
		courseList.add(mockCourse);
		
		Mockito.when(studentService.retrieveCourses(Mockito.anyInt())).thenReturn(courseList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/101/courses")
										.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().toString());
		String expected = "[{\"id\":\"1\",\"name\":\"Smallest Number\",\"description\":\"10\"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
	}

	@Test
	public void createStudentCourse() throws Exception {
		Course mockCourse = new Course("1", "Smallest Number", "1",
				Arrays.asList("1", "2", "3", "4"));

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				studentService.addCourse(Mockito.anyInt(),
						Mockito.any(Course.class))).thenReturn(mockCourse);

		// Send course as body to /students/101/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students/101/courses")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/students/101/courses/1",
				response.getHeader(HttpHeaders.LOCATION));

	}

}
