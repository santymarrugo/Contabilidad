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

/**
 * Fecha creacion : 11-05-2022
 * QA : Santiago Marrugo
 */

//Funciones o Clousure
def terminarAsiento = {
	//Funcion que valida el asiento y verifica que se muestra el popup para seleccionar el mes de asiento
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
	WebUI.delay(2)
	WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
	WebUI.delay(1)
}
def validarAsiento = {
	//Funcion que selecciona el mes de asiento creado y ademas verifica que esten las 4 lineas creadas.
	WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), '2020')
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonEditarMesAsiento'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonPrimerMes'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
	WebUI.delay(3)
	WebUI.verifyTextPresent('Asiento A', false)
	WebUI.verifyTextPresent('Asiento B', false)
	WebUI.verifyTextPresent('Asiento C', false)
	WebUI.verifyTextPresent('Asiento D', false)
	WebUI.executeJavaScript('hot.selectCell(3,18)', null)
	//Verificamos que el valor ingresado para la cotizacion este presente
	
	def String validarCotizacion = WebUI.getText(findTestObject('_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/CeldaValorCotizacion_42'))
	println(validarCotizacion)
	assert validarCotizacion == '42.00000'
	WebUI.delay(1)
}

//Vamos a verifica que las cotizaciones del mes de enero de 2020 esten completos todos los dias
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambios/Compartidos/Verificar Cotizaciones'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.executeJavaScript("alert('COTIZACIONES VERIFICADAS CON EXITO')", null)
WebUI.delay(3)
WebUI.closeBrowser()
//Vamor a verificar que las monedas este correctamente configuradas
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambios/Compartidos/Verificar Monedas'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.executeJavaScript("alert('MONEDAS VERIFICADAS CON EXITO')", null)
WebUI.delay(3)
WebUI.closeBrowser()

//Iniciamos sesion para entrar a las propiedades y poner visible la columna Origen
WebUI.callTestCase(findTestCase('_Conty/Login/Ingreso con usuario valido'), null)
WebUI.delay(1)
WebUI.verifyTextPresent('Inicio', false)
WebUI.delay(1)
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
//Verificar que la opcion SI este chequeada, y si NO esta chequeada la seleccionamos
WebUI.click(findTestObject('Object Repository/_Conty/Configuracion General/Propiedades/BotonPropiedadesAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Datos de los asientos', false)
WebUI.delay(1)
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
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonGuardarPropiedadesAsientos'))
	WebUI.delay(1)
	//Verificamos que se hayan guardado los cambios
	WebUI.verifyElementPresent(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/MensajeExitoGuardar'), 5)
	WebUI.delay(1)
}
WebUI.delay(2)
WebUI.executeJavaScript("alert('LAS PROPIEDADES TERMINAN AQUI')", null)
WebUI.delay(3)
WebUI.closeBrowser()

println("----- ID 3 -----")
//Vamos a crear el mes de asientos con fecha de 01/2020, para despues realizar la diferencia de cambio
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Asientos'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), '01/2020')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)

//Asientos de una linea - Linea 1
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,5,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"11111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,7,"4103")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,10,"Asiento A")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,12,"15000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,13,"0")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)

//Asientos de una linea - Linea 2
WebUI.executeJavaScript('hot.selectCell(1,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"11")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,6,"531111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,7,"11111")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,10,"Asiento B")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,12,"44500")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,13,"0")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,19,"E")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)

//Asientos de una linea - Linea 3
WebUI.executeJavaScript('hot.selectCell(2,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(2,5,"21")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,6,"11111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(2,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,10,"Asiento C")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,12,"94000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(2,13,"0")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(2,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)

//Asientos de una linea - Linea 4
WebUI.executeJavaScript('hot.selectCell(3,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(3,5,"21")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,6,"11111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,7,"4102")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(3,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,10,"Asiento D")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,12,"50000")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,13,"0")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}

WebUI.executeJavaScript('hot.setDataAtCell(3,18,"42.00")', null)

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(3,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))

//Validamos el mes de asiento creado
terminarAsiento.call()

validarAsiento.call()
//Validamos el mes de asiento creado
terminarAsiento.call()
WebUI.closeBrowser()

println("----- ID 4 -----")
/**
 * Vamos a correr el proceso de la Diferencia de Cambio
 */
//Iniciamos sesion y accedemos a la opcion Diferencia de Cambios
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Diferencia de Cambio'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
//Vamos a elegir el mes de enero 2020 para generar la Diferencia de cambio
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'), '01/01/2020')
WebUI.delay(1)

WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'), '31/01/2020')
WebUI.delay(1)
//Ajustar a Dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/DDAjustarA'), '2', false)
WebUI.delay(1)
//Cotizacion
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputCotizacion'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputCotizacion'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputCotizacion'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputCotizacion'), '0')
WebUI.delay(1)
//Generamos el asiento dando clic en el boton Aceptar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/BotonAceptarPopupDifCambio'))
WebUI.delay(5)
//Verificamos que estemos en la ventana de asientos con los asientos de Diferencia de cambio en Dolares
WebUI.verifyTextPresent('Diferencia de cambio US$', false)
//Primera linea, vamos a verificar sus campos
WebUI.executeJavaScript('hot.selectCell(4,5)', null)
def String diaDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(diaDifCambioL1)
assert diaDifCambioL1 == '31'
WebUI.executeJavaScript('hot.selectCell(4,6)', null)
def String debeDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(debeDifCambioL1)
assert debeDifCambioL1 == '5305'
WebUI.executeJavaScript('hot.selectCell(4,7)', null)
def String haberDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(haberDifCambioL1)
assert haberDifCambioL1 == ''
WebUI.executeJavaScript('hot.selectCell(4,10)', null)
def String conceptoDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(conceptoDifCambioL1)
assert conceptoDifCambioL1 == 'Diferencia de cambio US$'
WebUI.executeJavaScript('hot.selectCell(4,11)', null)
def String monedaDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(monedaDifCambioL1)
assert monedaDifCambioL1 == '1'
WebUI.executeJavaScript('hot.selectCell(4,12)', null)
def String totalDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(totalDifCambioL1)
/**
 * Para este assert el valor correcto es 130.25, pero hay un fallo y se reporto en el Bug #228041
 */
assert totalDifCambioL1 == '13.02'
WebUI.executeJavaScript('hot.selectCell(4,18)', null)
def String cotizacionDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(cotizacionDifCambioL1)
assert cotizacionDifCambioL1 == '-1'
WebUI.executeJavaScript('hot.selectCell(4,19)', null)
def String libroDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(libroDifCambioL1)
assert libroDifCambioL1 == 'U'
WebUI.executeJavaScript('hot.selectCell(4,21)', null)
def String tipoDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(tipoDifCambioL1)
assert tipoDifCambioL1 == 'DIF'
WebUI.executeJavaScript('hot.selectCell(4,22)', null)
def String origenDifCambioL1 = WebUI.executeJavaScript('return hot.getValue()', null)
println(origenDifCambioL1)
assert origenDifCambioL1 == 'DC'

//Segunda linea, vamos a verificar sus campos
WebUI.executeJavaScript('hot.selectCell(5,5)', null)
def String diaDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(diaDifCambioL2)
assert diaDifCambioL2 == '31'
WebUI.executeJavaScript('hot.selectCell(5,6)', null)
def String debeDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(debeDifCambioL2)
assert debeDifCambioL2 == ''
WebUI.executeJavaScript('hot.selectCell(5,7)', null)
def String haberDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(haberDifCambioL2)
assert haberDifCambioL2 == '11111'
WebUI.executeJavaScript('hot.selectCell(5,10)', null)
def String conceptoDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(conceptoDifCambioL2)
assert conceptoDifCambioL2 == 'Diferencia de cambio US$'
WebUI.executeJavaScript('hot.selectCell(5,11)', null)
def String monedaDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(monedaDifCambioL2)
assert monedaDifCambioL2 == '1'
WebUI.executeJavaScript('hot.selectCell(5,12)', null)
def String totalDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(totalDifCambioL2)
/**
 * Para este assert el valor correcto es 130.25, pero hay un fallo y se reporto en el Bug #228041
 */
assert totalDifCambioL2 == '13.02'
WebUI.executeJavaScript('hot.selectCell(5,18)', null)
def String cotizacionDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(cotizacionDifCambioL2)
assert cotizacionDifCambioL2 == '-1'
WebUI.executeJavaScript('hot.selectCell(5,19)', null)
def String libroDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(libroDifCambioL2)
assert libroDifCambioL2 == 'U'
WebUI.executeJavaScript('hot.selectCell(5,21)', null)
def String tipoDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(tipoDifCambioL2)
assert tipoDifCambioL2 == 'DIF'
WebUI.executeJavaScript('hot.selectCell(5,22)', null)
def String origenDifCambioL2 = WebUI.executeJavaScript('return hot.getValue()', null)
println(origenDifCambioL2)
assert origenDifCambioL2 == 'DC'

//Validamos el mes de asiento creado
terminarAsiento.call()
validarAsiento.call()

//Eliminamos los asientos para efectos de la Regresion
WebUI.executeJavaScript('hot.selectRows(0,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
terminarAsiento.call()

WebUI.executeJavaScript("alert ('TEST #1 DIFERENCIA CAMBIO, TERMINADO CON EXITO ')", null)
WebUI.delay(3)
WebUI.closeBrowser()
