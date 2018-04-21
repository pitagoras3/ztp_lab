# ZTP (Zaawansowane Techniki Programowania) - Laboratorium
Repozytorium w którym znajdują się rozwiązania zadań z przedmiotu _Zaawansowane Techniki Programowania_, na który uczęszczam podczas studiów na Politechnice Wrocławskiej.

## [lab1] SimpleMVC
Program oparty o architekturę MVC napisany w Javie, z wykorzystaniem repozytorium Mavena. Widokiem aplikacji jest konsola, więc w programie zastosowałem ViewControllery, zamiast rozbicia na poszczególne warstwy. Głównym problemem zadania było przełączanie się pomiędzy różnymi źródłami danych w czasie działania aplikacji - problem ten został rozwiązany z wykorzystaniem Dependency Injection i wzorca dostępu do danych DAO. Program potrafi współpracować z 2 źródłami danych - plikiem JSON oraz bazą danych opartą na MySQL. Do operacji CRUD na pliku JSON wykorzystałem bibliotekę Gson.

## [lab2] Polymorphizm
W programie należało wykorzystać wszystkie typy polimorfizmu:
- Polimorfizm inkluzyjny
- Polimorfizm ad hoc
	- Koercje
	- Przeciazanie
- Polimorfizm typów
	- Polimorifzm parametryczny
	- Polimorfizm ograniczeniowy

## [lab3] Reflections
Zadanie 3 polegało na wykorzystaniu mechanizmów refleksji do stworzenia instancji obiektów typu generycznego i tablicy obiektów typu generycznego. Dodatkowo nalezalo zaimplementować metodę clone dla dowolnego typu generycznego (z jedenym parametrem generycznym) oraz klasę z dwoma polami zgodnymi z tym parametrem (np. Pair<T> lub podobna klasa).

## [lab4] Performance
W zadaniu 4 nalezało sprawdzić czy zastępienie ArrayListy zwykłą tablicą przyspieszy wykonywanie konretnej operacji (w moim przypadku było to sortowanie tablicy).

Tablice sortowane były z wykorzystaniem statycznej metody klasy _Array_

```Java
Arrays.sort(array);
```

Jednak _niezalezne od tablicy_ sortowanie Arraylisty osiągnąłem poprzez wykorzystanie __strumieni__ w Javie 8.

```Java
list.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
```

_Uzyskane wyniki czasowe_

Ponizsze wyniki czasowe przedstawione są w _nanosekundach_.

|           | 1000          | 10 000            | 100 000       |
|-----------| ------------: |-------------:     | -----:        |
|Array      |   83471       | 888391            | 9971145       |
|ArrayList  |   359399      | 2672911           | 36849428      |
