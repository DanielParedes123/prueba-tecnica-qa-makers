Feature: Inicio de sesion en SauceDemo

  Como usuario
  Quiero iniciar sesión en la aplicacion web
  Para acceder al sistema


  Scenario: Login exitoso con credenciales validas
    Given que el usuario esta en la pagina de login
    When ingresa usuario "standard_user" y clave "secret_sauce"
    Then deberia ver la pagina principal


  Scenario: Login fallido con clave incorrecta
    Given que el usuario esta en la pagina de login
    When ingresa usuario "standard_user" y clave "wrong_password"
    Then deberia ver un mensaje de error


  Scenario: Validacion username vacio
    Given que el usuario esta en la pagina de login
    When ingresa usuario "" y clave "secret_sauce"
    Then deberia ver mensajes de campos requeridos


  Scenario: Validacion password vacio
    Given que el usuario esta en la pagina de login
    When ingresa usuario "standard_user" y clave ""
    Then deberia ver mensajes de campos requeridos
