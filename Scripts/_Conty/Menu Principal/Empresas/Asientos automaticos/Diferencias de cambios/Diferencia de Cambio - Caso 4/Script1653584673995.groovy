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
 * Fecha creacion : 26-05-2022
 * QA : Santiago Marrugo
 */

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
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), '04/2020')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)

//Asientos de una linea - Linea 1
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,5,"5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,6,"11111")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.executeJavaScript('hot.setDataAtCell(0,7,"1112022")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(0,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,10,"PruebaAsientoConError_linea_1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(0,12,"1500")', null)
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
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"5")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//WebUI.executeJavaScript('hot.setDataAtCell(1,6,"1112022")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,7,"4101")', null)
for(i=0; i<2; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,9,"1")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,10,"PruebaAsientoConError_linea_2")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,11,"0")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,12,"1501")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,13,"0")', null)
for(i=0; i<3; i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.executeJavaScript('hot.setDataAtCell(1,19,"I")', null)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.delay(1)

//Procedemos a validar el asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
//Se muestra el popup indicando que el asiento esta desbalanceado y hacemos clic en NO, para de esta forma guardar el asiento con errores.
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNOPopupTerminarAsiento'))
WebUI.delay(1)
//Verificamos que nos muestra el pop up de Asientos
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)
WebUI.executeJavaScript("alert('Aqui termina la creacion del Asiento DESBALANCEADO')", null)
WebUI.delay(3)

WebUI.closeBrowser()

//Accedemos a la opcion de diferencia de cambio
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Diferencia de Cambio'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
//Vamos a elegir el mes de abril 2020 para generar la Diferencia de cambio
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaIniDifCambio'), '01/04/2020')
WebUI.delay(1)

WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaFinDifCambio'), '30/04/2020')
WebUI.delay(1)

//Ajustar a pesos
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/DDAjustarA'), '1', false)
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

//Validamos el mensaje que se debe mostrar cuando intentamos generar el asiento automatico con un asiento desbalanceado
def mensajeNoGenerarDifCambio_Pesos = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/MensajeDeNoGerenacionDiferenciaCambio'))
println(mensajeNoGenerarDifCambio_Pesos)
assert mensajeNoGenerarDifCambio_Pesos == 'No se puede generar el reporte porque no se encuentran validados los siguientes meses de asientos:'
WebUI.delay(2)
WebUI.verifyTextPresent('04/2020', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/BotonAceptarPopupMensajeNoGeneraDifCam'))
WebUI.delay(1)

//Intentamos generar el asiento automatico en dolares tambien para validar que no se permita en esta moneda
//Ajustar a dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/DDAjustarA'), '2', false)
WebUI.delay(1)
//Generamos el asiento dando clic en el boton Aceptar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/BotonAceptarPopupDifCambio'))
WebUI.delay(5)
//Verificamos que se muestre el popup indicando que el proceso no se puede correr porque no hay datos en el asiento.
def mensajeNoGenerarDifCambio_Dolares = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/MensajeDeNoGerenacionDiferenciaCambio'))
println(mensajeNoGenerarDifCambio_Dolares)
assert mensajeNoGenerarDifCambio_Dolares == 'No se puede generar el reporte porque no se encuentran validados los siguientes meses de asientos:'
WebUI.delay(2)
WebUI.verifyTextPresent('04/2020', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/BotonAceptarPopupMensajeNoGeneraDifCam'))
WebUI.delay(1)

//Vamos a proceder a eliminar los asientos, entramos al menu de asientos para ubicar el mes de 04/2022
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
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
WebUI.verifyTextPresent('PruebaAsientoConError_linea_1', false)
WebUI.verifyTextPresent('PruebaAsientoConError_linea_2', false)
WebUI.delay(1)

//Eliminamos los asientos para efectos de la Regresion
WebUI.executeJavaScript('hot.selectRows(0,1)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)

WebUI.executeJavaScript("alert ('TEST #4 DIFERENCIA CAMBIO, TERMINADO CON EXITO ')", null)
WebUI.delay(3)
WebUI.closeBrowser()


