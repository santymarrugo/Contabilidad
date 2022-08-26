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
 * Fecha creacion : 22-06-2022
 * QA : Santiago Marrugo
 */

//Iniciamos sesion
WebUI.callTestCase(findTestCase('_Conty/Login/Ingreso con usuario valido'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

//Seleccionamos el asiento enero 2022
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Editar un mes de asientos existentes', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonEditarMesAsiento'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesEnero2022'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Asientos 1/2022', false)

//Cambiamos el dia del asiento por un 11, sin importar si ya tiene asignado un 11 en la celda
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.setDataAtCell(0,5,"11")', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(1,5)', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"11")', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(2,5)', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.setDataAtCell(2,5,"11")', null)

//Cambiamos la moneda del asiento por un 1, sin importar si ya tiene asignado un 1 en la celda
WebUI.executeJavaScript('hot.selectCell(0,11)', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"1")', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(1,11)', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.setDataAtCell(1,11,"1")', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.selectCell(2,11)', null)
WebUI.delay(0.5)
WebUI.executeJavaScript('hot.setDataAtCell(2,11,"1")', null)

//Cerramos la edicion del asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Editar un mes de asientos existentes', false)
WebUI.delay(1)

WebUI.executeJavaScript("alert('Fechas y Moneda cambiada con exito')", null)
WebUI.delay(3)
