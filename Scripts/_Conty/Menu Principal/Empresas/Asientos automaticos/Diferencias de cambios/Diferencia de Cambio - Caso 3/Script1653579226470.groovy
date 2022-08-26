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
//Vamos a correr el proceso de la Diferencia de Cambio usando el mes de Abril del 2022, el cual no tiene asientos y vamos a
//validar que se muestre el popup indicando que el proceso no se puede correr porque no hay datos en el asiento.
//Iniciamos sesion y accedemos a la opcion Diferencia de Cambios
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
//Verificamos que se muestre el popup indicando que el proceso no se puede correr porque no hay datos en el asiento.
def mensajeNoGenerarDifCambio_Pesos = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/MensajeDeNoGerenacionDiferenciaCambio'))
println(mensajeNoGenerarDifCambio_Pesos)
assert mensajeNoGenerarDifCambio_Pesos == 'No se puede generar el reporte porque no se cuenta con datos según los parámetros ingresados para su emisión.'
WebUI.delay(2)
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
assert mensajeNoGenerarDifCambio_Dolares == 'No se puede generar el reporte porque no se cuenta con datos según los parámetros ingresados para su emisión.'
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/BotonAceptarPopupMensajeNoGeneraDifCam'))
WebUI.delay(1)

WebUI.executeJavaScript("alert ('TEST #3 DIFERENCIA CAMBIO, TERMINADO CON EXITO ')", null)
WebUI.delay(3)
WebUI.closeBrowser()
