package ru.java.rush.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.ProviderEntity;
import ru.java.rush.repositories.ProviderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public void saveAll(List<ProviderEntity> providerEntity){
        providerRepository.saveAll(providerEntity);
    }

    public void save(ProviderEntity providerEntity){
        providerRepository.save(providerEntity);
    }

    public List<ProviderEntity> getAll(){ //аналогично добавте метод поиска getAll() в сервис фруктов
        return providerRepository.findAll();
    }
}