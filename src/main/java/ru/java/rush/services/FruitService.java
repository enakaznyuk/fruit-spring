package ru.java.rush.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.FruitEntity;
import ru.java.rush.repositories.FruitRepository;

import java.util.List;

@RequiredArgsConstructor
@Service//помечаем что этот бин - сервис
public class FruitService {

    private final FruitRepository fruitRepository;  //final переменная репозитория

    //создали публичный метод (название любое может быть)
//на вход принимает сущность и сохраняет ее в базу
    public void save(FruitEntity fruitEntity){
        fruitRepository.save(fruitEntity); //реализовали метод внедренного бина
    }

    public void saveAll(List<FruitEntity> fruitEntity){
        fruitRepository.saveAll(fruitEntity);
    }

    public void deleteById(Integer id){
        fruitRepository.deleteById(id);
    }

    //возвращает лист всех сущностей из базы
    public List<FruitEntity> getAll(){
        return fruitRepository.findAll(); //реализовали метод внедренного бина
    }

    public List<String> joinString(){
        return fruitRepository.joinSting();
    }

    public List<FruitEntity> joinFruit(){
        return fruitRepository.joinFruit();
    }

    public List<String> joinSqlFruit(){
        return fruitRepository.joinSqlFruit();
    }

}