//package cs.swe632.smartclassregistration.springboot.client;
//
//import java.net.URI;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import cs.swe632.smartclassregistration.springboot.model.Student;
//
//public class RestSmartClassClientUtil {
//	public void getStudentByIdDemo() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/article/{id}";
//		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//		ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student.class, 1);
//		Student article = responseEntity.getBody();
//		System.out.println("Id:"+article.getStudentId()+", Title:"+article.getTitle()
//		+", Category:"+article.getCategory());      
//	}
//	public void getAllStudentsDemo() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/articles";
//		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//		ResponseEntity<Student[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student[].class);
//		Student[] articles = responseEntity.getBody();
//		for(Student article : articles) {
//			System.out.println("Id:"+article.getStudentId()+", Title:"+article.getTitle()
//			+", Category: "+article.getCategory());
//		}
//	}
//	public void addStudentDemo() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/article";
//		Student objStudent = new Student();
//		objStudent.setTitle("Spring REST Security using Hibernate");
//		objStudent.setCategory("Spring");
//		HttpEntity<Student> requestEntity = new HttpEntity<Student>(objStudent, headers);
//		URI uri = restTemplate.postForLocation(url, requestEntity);
//		System.out.println(uri.getPath());    	
//	}
//	public void updateStudentDemo() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/article";
//		Student objStudent = new Student();
//		objStudent.setStudentId(1);
//		objStudent.setTitle("Update:Java Concurrency");
//		objStudent.setCategory("Java");
//		HttpEntity<Student> requestEntity = new HttpEntity<Student>(objStudent, headers);
//		restTemplate.put(url, requestEntity);
//	}
//	public void deleteStudentDemo() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/article/{id}";
//		HttpEntity<Student> requestEntity = new HttpEntity<Student>(headers);
//		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
//	}
//	public static void main(String args[]) {
//		RestSmartClassClientUtil util = new RestSmartClassClientUtil();
//		//util.getStudentByIdDemo();
//		util.getAllStudentsDemo();
//		//util.addStudentDemo();
//		//util.updateStudentDemo();
//		//util.deleteStudentDemo();
//	}    
//
//}
