//package prja.leetcode.challange.code25;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MockRestApiTest {
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @Before
//    public void setup() {
//        // Mock the REST API endpoints
//        when(restTemplate.getForObject("https://example.com/success", String.class))
//                .thenReturn("Success!");
//        when(restTemplate.getForObject("https://example.com/bad-request", String.class))
//                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad request"));
//        when(restTemplate.getForObject("https://example.com/unauthorized", String.class))
//                .thenThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Unauthorized"));
//        when(restTemplate.getForObject("https://example.com/not-found", String.class))
//                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not found"));
//        when(restTemplate.getForObject("https://example.com/internal-server-error", String.class))
//                .thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"));
//    }
//
//    @Test
//    public void testSuccess() {
//        ResponseEntity<String> response = restTemplate.getForObject("https://example.com/success", String.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Success!", response.getBody());
//    }
//
//    @Test
//    public void testBadRequest() {
//        try {
//            restTemplate.getForObject("https://example.com/bad-request", String.class);
//            fail("Expected HttpClientErrorException");
//        } catch (HttpClientErrorException e) {
//            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
//            assertEquals("Bad request", e.getMessage());
//        }
//    }
//
//    @Test
//    public void testUnauthorized() {
//        try {
//            restTemplate.getForObject("https://example.com/unauthorized", String.class);
//            fail("Expected HttpClientErrorException");
//        } catch (HttpClientErrorException e) {
//            assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
//            assertEquals("Unauthorized", e.getMessage());
//        }
//    }
//
//    @Test
//    public void testNotFound() {
//        try {
//            restTemplate.getForObject("https://example.com/not-found", String.class);
//            fail("Expected HttpClientErrorException");
//        } catch (HttpClientErrorException e) {
//            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
//            assertEquals("Not found", e.getMessage());
//        }
//    }
//
//    @Test
//    public void testInternalServerError() {
//        try {
//            restTemplate.getForObject("https://example.com/internal-server-error", String.class);
//            fail("Expected HttpClientErrorException");
//        } catch (HttpClientErrorException e) {
//            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, e.getStatusCode());
//            assertEquals("Internal server error", e.getMessage());
//        }