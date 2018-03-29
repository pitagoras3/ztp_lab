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