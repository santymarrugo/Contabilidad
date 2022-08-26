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
 * Fecha creacion : 24-06-2022
 * QA : Santiago Marrugo
 */

//Se verifican las cotizaciones en Peso Argentino del mes de enero de 2022
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/Compartidos/Verificar Cotizaciones - Pesos Argentinos - 01-2022'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(0.5)
WebUI.executeJavaScript("alert('COTIZACIONES EN DOLARES VERIFICADAS CON EXITO')", null)
WebUI.delay(3)
WebUI.closeBrowser()
//Se verifican las cotizaciones en Euros del mes de enero de 2022
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/Compartidos/Verificar Cotizaciones - Euros - 01-2022'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(0.5)
WebUI.executeJavaScript("alert('COTIZACIONES EN EUROS VERIFICADAS CON EXITO')", null)
WebUI.delay(3)
WebUI.closeBrowser()

//Verificamos que el dia para generar este reporte sea 11 y que la moneda sea 1, es decir, pesos.
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/Compartidos/Verificar Asiento en Dolares'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.closeBrowser()

//Vamos ingresa a la opcion de Balances
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/Ingresos a Informes/Ingreso a Balances'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(0.5)

/**
 * Para este siguiente paso existe un bug por esa razon se deja comentado, BUG # 248159
 */
//Configuramos las opciones, generamos el reporte y verificamos sus calculos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/Reportes Core/Balance EDS-2M-PARG-E'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(0.5)

//Fin del test
WebUI.executeJavaScript("alert('TEST TERMINADO CON EXITO')", null)
WebUI.delay(3)
WebUI.closeBrowser()