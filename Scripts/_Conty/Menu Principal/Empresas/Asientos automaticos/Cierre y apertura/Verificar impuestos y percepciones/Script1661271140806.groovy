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
import com.kms.katalon.core.util.KeywordUtil as KWU

/**
 * Fecha creacion : 23-08-2022
 * QA : Santiago Marrugo
 */

//Ingresamos a la opcion impuestos y percepciones
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Configurar Impuestos y Percepciones'),[:], FailureHandling.STOP_ON_FAILURE)

//Verificamos las dos cuentas de impuestos que vamos a usar para el test de Cierre y apertura
WebUI.executeJavaScript('hot.selectCell(6, 2)', null)
def String cod_impuesto_8 = WebUI.executeJavaScript('return hot.getValue()', null)
KWU.logInfo(cod_impuesto_8)
WebUI.executeJavaScript('hot.selectCell(6, 3)', null)
def String cta_impuesto_8 = WebUI.executeJavaScript('return hot.getValue()', null)
KWU.logInfo(cta_impuesto_8)
assert cod_impuesto_8 == '8' && cta_impuesto_8 == '11332'

WebUI.executeJavaScript('hot.selectCell(7, 2)', null)
def String cod_impuesto_9 = WebUI.executeJavaScript('return hot.getValue()', null)
KWU.logInfo(cod_impuesto_9)
WebUI.executeJavaScript('hot.selectCell(7, 3)', null)
def String cta_impuesto_9 = WebUI.executeJavaScript('return hot.getValue()', null)
KWU.logInfo(cta_impuesto_9)
assert cod_impuesto_9 == '9' && cta_impuesto_9 == '21333'

KWU.markPassed('Impuestos y percepciones verificadas con exito')









