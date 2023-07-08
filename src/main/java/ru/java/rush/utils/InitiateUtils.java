package ru.java.rush.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.FruitEntity;
import ru.java.rush.entities.ProviderEntity;
import ru.java.rush.services.FruitService;
import ru.java.rush.services.ProviderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service //аннотация помечает бин как сервис
public class InitiateUtils implements CommandLineRunner { //имплементируем интерфейс CommandLineRunner (командная строка запуска)

    private final FruitService fruitService;
    private final ProviderService providerService;

    @Override
//переопределяем метод который позволит
//нам выполнять методы нашего приложения при запуске
    public void run(String... args) throws Exception {

        //инициализируем таблицу с фруктами
        List<FruitEntity> fruit = new ArrayList<>(
                Arrays.asList(
                        new FruitEntity()
                                .setFruitName("Fruit1")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),//сюда добавлен метод рандомного числа от 0 до 10
                        new FruitEntity()
                                .setFruitName("Fruit2")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit3")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit4")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit5")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit6")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit7")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit8")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit9")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10))
                )
        );

//инициализируем таблицу с поставщиками
        List<ProviderEntity> provider = new ArrayList<>(
                Arrays.asList(
                        new ProviderEntity()
                                .setProviderName("Provider1"),
                        new ProviderEntity()
                                .setProviderName("Provider2"),
                        new ProviderEntity()
                                .setProviderName("Provider3"),
                        new ProviderEntity()
                                .setProviderName("Provider4"),
                        new ProviderEntity()
                                .setProviderName("Provider5")
                )
        );

        fruitService.saveAll(fruit);//сохраняем List фруктов

        System.out.println("\nТаблица фруктов");
        for (FruitEntity fruitEntity : fruitService.getAll()) {
            System.out.println(fruitEntity);
        }

        providerService.saveAll(provider);//сохраняем List поставщиков

        System.out.println("\nТаблица поставщиков");
        for (ProviderEntity providerEntity : providerService.getAll()) {
            System.out.println(providerEntity);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (String join : fruitService.joinString()) {
            System.out.println(join);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (FruitEntity join : fruitService.joinFruit()) {
            System.out.println(join);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (String join : fruitService.joinSqlFruit()) {
            System.out.println(join);
        }
    }
}