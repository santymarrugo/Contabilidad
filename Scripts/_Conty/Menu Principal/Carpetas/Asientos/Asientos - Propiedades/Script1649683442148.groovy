import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Iniciamos sesion
WebUI.callTestCase(findTestCase('_Conty/Login/Ingreso con usuario valido'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

_guardarPropiedades = {
	//Guardamos los cambios en las propiedades
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonGuardarPropiedadesAsientos'))
	WebUI.delay(1)
	//Verificamos que se hayan guardado los cambios
	WebUI.verifyElementPresent(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/MensajeExitoGuardar'), 5)
	WebUI.delay(1)
}
_ingresar_a_Propiedades = {
	WebUI.click(findTestObject('Object Repository/_Conty/Configuracion General/Propiedades/BotonConfiguracion'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Configuracion General/Propiedades/BotonPropiedades'))
	WebUI.delay(1)
	//Verificamos que estemos dentro de la pagina de configuracion empresa
	WebUI.verifyTextPresent('Identificación', false)
	WebUI.delay(1)
	WebUI.verifyTextPresent('Asientos', false)
	WebUI.delay(1)
	//Seleccionamos las asientos para ver sus propiedades
	WebUI.click(findTestObject('Object Repository/_Conty/Configuracion General/Propiedades/BotonPropiedadesAsientos'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Datos de los asientos', false)
	WebUI.delay(1)
}
_ingresar_a_Asientos = {
	//Accesamos a la opcion Asientos
	//Nos vamos a la grilla de asientos y verificamos que la columna RUT no aparezca
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabCarpetas'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Sub-TabAsientos_2'))
	WebUI.delay(2)
	//Verificamos que estemos en la ventana de Asientos
	WebUI.verifyTextPresent('Asientos - Selección', false)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
	WebUI.delay(1)
}

println("<----- ID 33 ---->")
//Hacemos el llamado al Clousure que nos permite ingresar a las propiedades
_ingresar_a_Propiedades.call()
//Verificar que la opcion NO este chequeada, y si esta chequeada la deseleccionamos
def boolean chequeado_3_NO = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk3").checked', null)
println(chequeado_3_NO)
WebUI.delay(1)
if (chequeado_3_NO == false) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_IngresarClientesProveedores'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que NO este la columna RUT
WebUI.verifyTextNotPresent("RUT", false)
WebUI.delay(2)

println("<----- ID 34 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos
def boolean chequeado_3_SI = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk3").checked', null)
println(chequeado_3_SI)
WebUI.delay(1)
if (chequeado_3_SI == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Chequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_IngresarClientesProveedores'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que SI este la columna RUT
WebUI.verifyTextPresent("RUT", false)
WebUI.delay(2)


println("<----- ID 35 ---->")
_ingresar_a_Propiedades.call()

//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos, para la columna S, esto se coloca aqui para que no falle
//al momento de evaluar la columna M
def boolean chequeado_13_SI_1 = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk13").checked', null)
println(chequeado_13_SI_1)
WebUI.delay(1)
if (chequeado_13_SI_1 == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_UsaDistintosConceptosOLeyendas'))
	WebUI.delay(1)
}


//Verificar que la opcion NO este chequeada, y si esta chequeada la deseleccionamos
def boolean chequeado_7_NO = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk7").checked', null)
println(chequeado_7_NO)
WebUI.delay(1)
if (chequeado_7_NO == false) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Chequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_IngresaMonedaExtCotizaciones'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que NO este la columna M
def columnaMNoVisible = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelCabeceraColumna_M'))
println(columnaMNoVisible)
assert columnaMNoVisible != 'M'

WebUI.delay(1)

println("<----- ID 36 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion SI este chequeada, y si esta deschequeada la seleccionamos
def boolean chequeado_7_SI = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk7").checked', null)
println(chequeado_7_SI)
WebUI.delay(1)
if (chequeado_7_SI == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Chequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_IngresaMonedaExtCotizaciones'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que SI este la columna M
def columnaMVisible = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelCabeceraColumna_M'))
println(columnaMVisible)
assert columnaMVisible == 'M'
WebUI.delay(1)

println("<----- ID 37 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion NO este chequeada, y si esta chequeada la deseleccionamos
def boolean chequeado_13_NO = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk13").checked', null)
println(chequeado_13_NO)
WebUI.delay(1)
if (chequeado_13_NO == false) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_UsaDistintosConceptosOLeyendas'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que NO este la columna S
def String columnaSNoVisible = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelCabeceraColumna_S'))
println(columnaSNoVisible)
assert columnaSNoVisible != 'S'

println("<----- ID 38 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos
def boolean chequeado_13_SI = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk13").checked', null)
println(chequeado_13_SI)
WebUI.delay(1)
if (chequeado_13_SI == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Chequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_UsaDistintosConceptosOLeyendas'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que SI este la columna S
def String columnaSVisible = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelCabeceraColumna_S'))
println(columnaSVisible)
assert columnaSVisible == 'S'

println("<----- ID 40 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos
def boolean chequeado_14_SI = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk14").checked', null)
println(chequeado_14_SI)
WebUI.delay(1)
if (chequeado_14_SI == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_UsarDistintosConceptosLeyenNumeros'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que SI este la columna N° asiento
WebUI.verifyTextPresent("N° asiento", false)
WebUI.delay(2)

println("<----- ID 39 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion NO este chequeada, y si esta chequeada la deseleccionamos
def boolean chequeado_14_NO = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk14").checked', null)
println(chequeado_14_NO)
WebUI.delay(1)
if (chequeado_14_NO == false) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_UsarDistintosConceptosLeyenNumeros'))
	WebUI.delay(1)
	//Chequeamos nuevamente el permiso de la columna S, ya que en el Test de Exportar necesitamos que este presente
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_UsaDistintosConceptosOLeyendas'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que NO este la columna N° asiento
WebUI.verifyTextNotPresent("N° asiento", false)
WebUI.delay(2)

println("<----- ID 41 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion NO este chequeada, y si esta chequeada la deseleccionamos
def boolean chequeado_11_NO = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk11").checked', null)
println(chequeado_11_NO)
WebUI.delay(1)
if (chequeado_11_NO == false) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_IngresaTiposAsientos'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que NO este la columna Tipo
WebUI.verifyTextNotPresent("Tipo", false)
WebUI.delay(2)

println("<----- ID 42 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos
def boolean chequeado_11_SI = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk11").checked', null)
println(chequeado_11_SI)
WebUI.delay(1)
if (chequeado_11_SI == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_IngresaTiposAsientos'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que SI este la columna Tipo
WebUI.verifyTextPresent("Tipo", false)
WebUI.delay(2)

println("<----- ID 44 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos
def boolean chequeado_12_SI = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk12").checked', null)
println(chequeado_12_SI)
WebUI.delay(1)
if (chequeado_12_SI == true) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_MuestraOrigenAsientos'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que SI este la columna Asiento Origen
WebUI.verifyTextPresent("Origen", false)
WebUI.delay(2)


println("<----- ID 43 ---->")
_ingresar_a_Propiedades.call()
//Verificar que la opcion NO este chequeada, y si esta chequeada la deseleccionamos
def boolean chequeado_12_NO = WebUI.executeJavaScript('return document.getElementById("propiedadesAsientoChk12").checked', null)
println(chequeado_12_NO)
WebUI.delay(1)
if (chequeado_12_NO == false) {
	println("NO HACEMOS NADA Y EL TEST SIGUE")
	WebUI.delay(1)
} else {
	WebUI.delay(1)
	//Deschequeamos la casilla
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/Propiedades Asientos/Chk_MuestraOrigenAsientos'))
	WebUI.delay(1)
	//Guardamos los cambios en las propiedades
	_guardarPropiedades.call()
}
WebUI.delay(1)
//Accesamos a la opcion Asientos
_ingresar_a_Asientos.call()
//Verificamos que NO este la columna Asiento Origen
WebUI.verifyTextNotPresent("Origen", false)
WebUI.delay(2)

println("<----- ID 32 ---->")
//Vamos a crear una nueva linea de asiento para 210327080019

WebUI.executeJavaScript("alert('AQUI TERMINA EL TEST')", null)
WebUI.delay(3)

WebUI.closeBrowser()

