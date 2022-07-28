package com.bosonit.sa2.file.application.register;

import com.bosonit.sa2.file.application.register.port.RegisterStoragePort;
import com.bosonit.sa2.file.domain.File;
import com.bosonit.sa2.file.exception.RegisterStorageException;
import com.bosonit.sa2.file.infraestructure.dto.FileDto;
import com.bosonit.sa2.file.infraestructure.repository.RegisterStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class RegisterStorageUseCase implements RegisterStoragePort {
    @Autowired
    RegisterStorageRepository registerStorageRepository;

    @Override
    public File registerFile(FileDto fileDto) {
        return registerStorageRepository.save(new File(fileDto));
    }

    @Override
    public Path findById(long id) {
        return Path.of(registerStorageRepository.findById(id).orElseThrow(() -> {
            throw new RegisterStorageException("No se ha encontrado ningún fichero con dicha ID");
        }).getPath());
    }

    @Override
    public Path findByName(String name) {
        return Path.of(registerStorageRepository.findByName(name).get(0).getPath());
    }
}