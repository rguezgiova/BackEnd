package com.bosonit.bs12.feign;

import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feignTest", url = "http://localhost:8081")
public interface IFeignServer {
    @GetMapping("/profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable("id") String idProfesor);
}