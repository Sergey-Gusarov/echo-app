package ru.sergey_gusarov.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

@Log4j
@RestController
@RequestMapping("/")
public class EchoController<T> {

    private ResponseEntity<String> getStringResponseEntity(String logString) {
        log.info(logString);
        return ok("Request is: " + logString);
    }

    @PostMapping("/")
    public ResponseEntity<String> postController(@RequestBody T request, HttpServletRequest req) {
        final String logString = "POST, IP: " + req.getRemoteAddr() + ", request: " + request.toString();
        return getStringResponseEntity(logString);
    }

    @GetMapping("/{var}")
    public ResponseEntity<String> getController(@PathVariable String var, HttpServletRequest req) {
        final String logString = "GET, IP: " + req.getRemoteAddr() + ", request: " + var;
        return getStringResponseEntity(logString);
    }

    @GetMapping("/")
    public ResponseEntity<String> getEmptyController(HttpServletRequest req) {
        final String logString = "GET, IP: " + req.getRemoteAddr() + ", request: empty";
        return getStringResponseEntity(logString);
    }

    @PutMapping("/")
    public ResponseEntity<String> putController(@RequestBody T request, HttpServletRequest req) {
        final String logString = "PUT, IP: " + req.getRemoteAddr() + ", request: " + request.toString();
        return getStringResponseEntity(logString);
    }

    @PatchMapping("/")
    public ResponseEntity<String> patchController(@RequestBody T request, HttpServletRequest req) {
        final String logString = "PATCH, IP: " + req.getRemoteAddr() + ", request: " + request.toString();
        return getStringResponseEntity(logString);
    }

    @DeleteMapping("/{var}")
    public ResponseEntity<String> deleteController(@PathVariable String var, HttpServletRequest req) {
        final String logString = "DELETE, IP: " + req.getRemoteAddr() + ", request: " + var;
        return getStringResponseEntity(logString);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteEmptyController(HttpServletRequest req) {
        final String logString = "DELETE, IP: " + req.getRemoteAddr() + ", request: empty";
        return getStringResponseEntity(logString);
    }
}
