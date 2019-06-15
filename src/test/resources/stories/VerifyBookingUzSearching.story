Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User is able to search the e-tickets, by custom criterias

Given user proceeds to cite, using url: 'https://booking.uz.gov.ua'
When user searches E-tickets, by next criteria:
| from       | date       |
| Киев-Львов | 16.05.2019 |
Then following trains are available to book:
{transformer=FROM_LANDSCAPE}
| trainNumber | 002 Д               | 705 К               | 715 К               | 142 П               | 749 К               | 743 Л               |
| from        | Константиновка      | Киев-Пассажирский   | Киев-Пассажирский   | Бахмут              | Киев-Пассажирский   | Дарница             |
| to          | Ивано-Франковск     | Пшемысль            | Пшемысль            | Львов               | Ивано-Франковск     | Львов               |
| departure   | четверг, 16.05.2019 | четверг, 16.05.2019 | четверг, 16.05.2019 | четверг, 16.05.2019 | четверг, 16.05.2019 | четверг, 16.05.2019 |
| arrival     | четверг, 16.05.2019 | четверг, 16.05.2019 | четверг, 16.05.2019 | пятница, 17.05.2019 | четверг, 16.05.2019 | четверг, 16.05.2019 |
| starTime    | 04:02               | 06:00               | 06:50               | 13:36               | 14:07               | 17:33               |
| endTime     | 10:21               | 11:09               | 13:45               | 04:30               | 19:57               | 22:43               |
| inTransit   | 6:19                | 5:09                | 6:55                | 14:54               | 5:50                | 5:10                |
