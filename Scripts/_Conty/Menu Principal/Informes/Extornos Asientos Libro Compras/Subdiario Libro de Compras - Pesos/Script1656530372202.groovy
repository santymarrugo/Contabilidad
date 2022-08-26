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
 * Fecha creacion : 29-06-2022
 * QA : Santiago Marrugo
 */

//Inicio de sesion en la plataforma
WebUI.callTestCase(findTestCase('_Conty/Login/Ingreso con usuario valido'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(0.5)

//Creacion del Asiento, para febrero de 2022
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Reportes Core/Crear Asientos - Extornos'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(0.5)
WebUI.closeBrowser()

//Inicio de sesion y acceso a Subdiarios
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Informes Subdiarios'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

//Generacion del reporte
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Reportes Core/Subdiario L-C-P'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

//Eliminamos el mes de asiento, para efectos de le regresion
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Reportes Core/Eliminar Asientos - Extornos'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

//Fin del test
WebUI.executeJavaScript("alert('Reporte Generado con Exito')", null)
WebUI.delay(3)

WebUI.closeBrowser()