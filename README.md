#validator
Проект PasswordValidator выполняет проверку пароля применяя принцип раннего
возврата и охранных выражений, учитывая следующие требования:
1. Длина пароля находится в диапазоне [8, 32];
2. Пароль содержит хотя бы один символ в верхнем регистре;
3. Пароль содержит хотя бы один символ в нижнем регистре;
4. Пароль содержит хотя бы одну цифру;
5. Пароль содержит хотя бы один специальный символ;
6. Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user.

Для проверок использовались статические методы класса Character и были реализованы
Unit тесты.

************************************************************************************

The PasswordValidator project performs password verification using the principle of early
return and security expressions, taking into account the following requirements:
1. The password length is in the range [8, 32];
2. The password contains at least one uppercase character;
3. The password contains at least one character in lowercase;
4. The password contains at least one digit;
5. The password contains at least one special character;
6. The password does not contain a case-insensitive substring: qwerty, 12345, password, admin, user.

Static methods of the Character class were used for the checks and were implemented
Unit tests.