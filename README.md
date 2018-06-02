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

## [lab5] DesignPatterns
Zadanie 5 polegało na wykorzystaniu w projekcie dwóch wzorców projektowych z listy zaproponowanej przez doktor prowadzącą zajęcia. Z grupy kreujących wybrałem wzorzec __Budowniczy__, a z behawioralnych - __Stan__.

Wzorce wykorzystałem na stworzonej przeze mnie klasie _Connection_, która pozwalała na tworzenie połączeń z odpowiednim hostem i jego portem za pośrednictwem dowolnego protokołu. _Oczywiście całość jest zamockowana, nie powstaje zadne prawdziwe połączenie :(_

Klasa _Connection_ posiada pola wymagane oraz opcjonalne:

```Java
    //Required fields
    private int     port;
    private String  host;
    private String  protocol;

    //Optional fields
    private String  method;
    private String  data;
    private int     sendDelay;
    private int     timeout;
    private boolean getRespondMessage;
    private boolean showWarnings;
    private boolean setRetryWhenFail;
    private boolean setUseSSL;
```

Ze względu na sporą ilość pól wykorzystanie wzorca __Budowniczego__ było oczywistym faktem. Wzorzec __Stanu__ wykorzystałem przy definiowaniu _stanu_ połączenia - stan ten mógł być:

- Available,
- Unavailable,
- Connected,
- Disconnected

Interfejs _ConnectionState_ po którym dziedziczyły wszystkie stany zawierał w sobie 3 nagłówki metod:

```Java
package connection;

public interface ConnectionState {
    int AMOUNT_OF_CONNECTION_TYPES = 4;
    void connect(Connection connection);
    void logConnectionState();
    void disconnect(Connection connection);
}
```

Dzięki zastosowaniu wzorca __stanu__ mogłem pozbyć się wielopoziomowych if'ów, w których identyfikowałbym rodzaj danego połączenia.

## [lab6] Java8FunctionalFeatures

W zadaniu 6 mieliśmy napisać 3 powiązane ze sobą klasy

- Student,
- Wydział,
- Kurs

A następnie do wykonania pozostały 4 zadania:
- Filtrowanie kolekcji po odpowiednim kryterium,
- Mapowanie kolekcji,
- Wyciągnięcie wartości minimalnej / maksymalnej z kolekcji,
- Grupowanie obiektów klasy według pewnej cechy.

## [lab7] MySQLParser

W zadaniu 7 nalezalo zaimplementować program słuzący do parsowania własnego języka zapytań na MySQL. Do zaimplementowania mieliśmy następujące funkcje:
- Dodanie / Usunięcie tabeli,
- Dodanie / Usunięcie pola określonego typu,
- Ustawianie klucza głównego (mógł być prosty).

Dodatkowo, nalezało zastosować 2 strategie obsługi wyjątków.

Składnia mojego języka zapytań __MyQL__

### Dodanie tabeli
```
create table Students{
    int age;
    String name;
}
```
```SQL
CREATE TABLE Students (
	age int,
	name varchar(255)
);
```

### Usunięcie tabeli
```
delete table Students;
```
```SQL
DROP TABLE Students;
```

### Dodanie / Usunięcie pola określonego typu
```
alter table Students{
    add int age;
    add String surname;
    delete name;
}
```
```SQL
ALTER TABLE Students
DROP COLUMN name;

ALTER TABLE Students
ADD age int;

ALTER TABLE Students
ADD surname varchar(255);
```

### Ustawienie klucza głównego
```
set pk on Students as ID;
```
```SQL
ALTER TABLE Students
ADD PRIMARY KEY (ID);
```

Zastosowałem 2 strategie obsługi wyjątków:
- Przerwanie aplikacji spowodowane błędem walidacji,
- Niedokonanie parsowania i logowanie błędu (powiadomienie uzytkownika).

### Notacja BNF MyQL

```BNF
<lowercaseLetter> ::= 'a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'|'i'|'j'|'k'|'l'|'m'|'n'|'o'|'p'|'r'|'s'|'t'|'u'|'w'|'x'|'y'|'z'

<uppercaseLetter> ::= 'A'|'B'|'C'|'D'|'E'|'F'|'G'|'H'|'I'|'J'|'K'|'L'|'M'|'N'|'O'|'P'|'R'|'S'|'T'|'U'|'W'|'X'|'Y'|'Z'

<openingBracket> ::= '{'

<closingBracket> ::= '}'

<semicolon> ::= ';'

<space> ::= ' '

<createWord> ::= 'create'

<alterWord> ::= 'alter'

<tableWord> ::= 'table'

<addWord> ::= 'add'

<deleteWord> ::= 'delete'

<setWord> ::= 'set'

<pkWord> ::= 'pk'

<onWord> ::= 'on'

<tableName> ::= <upperCase> | <lowerCase> | <tableName> <upperCase> | <tableName> <lowercase> 

<objectType> ::= 'String'|'int'

<objectName> ::= <upperCase> | <lowerCase> | <objectName> <upperCase> | <tableName> <lowercase>

<query> ::= <createTableQuery> | <alterTableQuery> | <deleteTableQuery> | <setPKQuery>

<createTableQuery> ::= <createTableHeader> <space> <tableName> <openingBracket> <createTableBody> <closingBracket>

<createTableHeader> ::= <createWord> <space> <tableWord>

<createTableBody> ::= <createTableBodyLine> | <createTableBody> <createTableBodyLine> 

<createTableBodyLine> ::= <objectType> <space> <objectName> <semicolon> 

<alterTableQuery> ::= <alterTableHeader> <space> <tableName> <openingBracket> <alterTableBody> <closingBracket>

<alterTableHeader> ::= <alterWord> <space> <tableWord>

<alterTableBody> ::= <alterTableBodyLine> | <alterTableBody> <alterTableBodyLine>

<alterTableBodyLine> ::= <addWord> <space> <objectType> <space> <objectName> <semicolon> | <deleteWord> <space> <objectName> <semicolon>

<deleteTableQuery> ::= <deleteWord> <space> <tableName> <semicolon>

<setPKQuery> ::= <setWord> <space> <pkWord> <space> <onWord> <space> <tableName> <space> <onWord> <space> <objectName> <semicolon>
```