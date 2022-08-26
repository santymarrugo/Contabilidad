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
import internal.GlobalVariable
import io.netty.util.concurrent.FailedFuture

import org.openqa.selenium.Keys as Keys

/**
 * Fecha creacion : 9-06-2022
 * QA : Santiago Marrugo
 */

//Iniciamos sesion en Conty
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Cotizaciones'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
//Seleccionamos como moneda el Euro
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/DropDMoneda'), '9', false)
WebUI.delay(1)
//Seleccionamos el mes de enero de 2022, que es el mes de prueba
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaCotizaciones'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaCotizaciones'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaCotizaciones'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/InputFechaCotizaciones'), '01/2022')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Diferencias de cambio/BotonAceptarPopupCotizaciones'))
WebUI.delay(2)
//Verificamos que el mes de enero tenga sus 31 registros de cotizaciones
def String diasCotizaciones = WebUI.executeJavaScript('return hot.countRows()', null)
println(diasCotizaciones)
assert diasCotizaciones == '31'
//Verificamos el primer dia, ultimo dia, el dia 5 y el dia 11 del mes
WebUI.verifyTextPresent('Sábado 1', false)
WebUI.verifyTextPresent('Miércoles 5', false)
WebUI.verifyTextPresent('Martes 11', false)
WebUI.verifyTextPresent('Lunes 31', false)

//Nos aseguramos que los valores de las cotizaciones para los dias 5 y 11 sean los correctos.
WebUI.executeJavaScript('hot.selectCell(4,2)', null)
def String dia5 = WebUI.executeJavaScript('return hot.getValue()', null)
assert dia5 == '50.44756'
WebUI.executeJavaScript('hot.selectCell(10,2)', null)
def String dia11 = WebUI.executeJavaScript('return hot.getValue()', null)
assert dia11 == '50.57874'
println(dia5)
println(dia11)


//Verificamos que la cotizacion sea en euros
WebUI.verifyTextPresent('Cotizaciones € - 01/2022', false)
WebUI.delay(0.5)