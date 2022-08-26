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
 * Fecha creacion : 30-06-2022
 * QA : Santiago Marrugo
 */

//Accedemos a la opcion Asientos
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(0.5)
WebUI.verifyTextPresent('2/2022', false)
//Entramos al asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonEditarMesAsiento'))
WebUI.delay(0.5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/RadioButton02-2022'))
WebUI.delay(0.5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(2)
WebUI.verifyTextPresent('Debe', false)
//Seleccionamos las filas del asiento y eliminamos los asientos
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.executeJavaScript('hot.selectRows(0,5)', null)
WebUI.delay(2)
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(2)
WebUI.verifyTextNotPresent('531117', false)
WebUI.delay(2)
WebUI.verifyTextNotPresent('Servicios varios EXTORNO', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextNotPresent('2/2022', false)