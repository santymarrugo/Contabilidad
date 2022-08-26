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
 * Fecha creacion : 26-08-2022
 * QA : Santiago Marrugo
 */

//Entramos al mes de asientos
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/RadioButtonMesCierreApertura'))
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Asientos 2/2022', false)

//Seleccionamos los asientos
WebUI.executeJavaScript('hot.selectRows(0, 25)', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(1)
WebUI.verifyTextNotPresent('02/2022', false)