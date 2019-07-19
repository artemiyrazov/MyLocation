## Android-приложение MyLocation

### Общая информация 
Андроид-приложение MyLocation разработано в рамках прохождения производственной практики. 
Данное приложение создано с целью получения навыков разработки мобильных приложений и  взаимодействия 
с системой Android. 

### Используемые инструменты
Язык разработки приложения - Java. Среда разработки (IDE) - Android studio. 
Минимально поддерживаемая версия API: 29 (Android 9) . 
Приложение протестировано вручную на эмуляторе Android (Google Pixel 2 API 29), а также на одном реальном устройстве (Xiaomi). 
Для постоянного взаимодействия команды в работе над продуктом используется Github. Данный репозиторий содержит главную ветку master со стабильными релизными версиями приложения, 
рабочую ветку develop, а также другие ветки для работы над конкретным функционалом. 

### Структура проекта 
Приложение основано на шаблоне Navigation drawer activity для более удобной навигации между элементами программы. 
Каждая функция программы выделена в собственную Activity, а также для каждого пункта меню создан Fragment и соответствующий XML Layout. 
Сложные структуры данных были выделены в отдельные классы. В приложении пользователь может посмотреть информацию об устройстве(Device info), входящие SMS сообщения(Messages), 
список контактов (Contacts), фотографии с устройства (Photos). 

### Функционал приложения 
**Пункт меню Device Info предоставляет следующую информацию:** производитель телефона, бренд телефона, модель телефона, 
имя устройства, версия ОС Android, Hardware name устройства. На layout данная информация передаётся в виде строки, 
отображённой на textView. 

**Пункт меню Contacts:** Имя контакта, номер телефона контакта. Информация о контактах хранится в виде списка объектов типа String, 
на layout данная информация отображается в listView

**Пункт меню Messages:** Номер телефона контакта, тело сообщения. На layout данная информация передаётся в виде строки, 
сообщения отделены друг от друга символом переноса строки. 

**Пункт меню Photos:** имя файла, дата создания файла. На layout данная информация передаётся в виде объектов пользовательского класса Image, 
отображенных на listView. 

____

#### UPD 19.07.2019

* Изменена логика Messages Activity. Теперь данная activity хранит сообщения не в виде единой строки, а в виде списка объектов String, а отображение на Layout реализовано через ListView 
