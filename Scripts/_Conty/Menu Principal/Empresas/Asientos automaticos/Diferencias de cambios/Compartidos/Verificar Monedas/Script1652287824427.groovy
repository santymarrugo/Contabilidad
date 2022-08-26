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

WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Configurar Monedas'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
//Verificamos las monedas que deben existir en el maestro que son Pesos, Dolares, Real brasileño y Euro
def String totalMonedas = WebUI.executeJavaScript('return hot.countRows()', null)
println(totalMonedas)
assert totalMonedas == '5'
//Verificamos el primer y ultimo dia del mes
WebUI.verifyTextPresent('Pesos', false)
WebUI.delay(1)
WebUI.verifyTextPresent('Dolares', false)
WebUI.delay(1)
WebUI.verifyTextPresent('Real brasileño', false)
WebUI.delay(1)
WebUI.verifyTextPresent('Euro', false)
WebUI.delay(1)