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
 * Fecha creacion : 25-08-2022
 * QA : Santiago Marrugo
 */

//Ingresamos a la plataforma, al menu Impuestos y percepciones y se verifican los mismos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Verificar impuestos y percepciones'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

//Creamos los asientos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Crear asientos'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

//Corremos el proceso de Cierre y apertura
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Generar cierre y apertura'), null)
WebUI.delay(1)

//Verificamos los asientos generados 02/2022
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Verificar cierre y apertura'), null)
WebUI.delay(1)

//Verificamos los asientos generados del mes siguiente 03/2022
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Verificar datos mes siguiente'), null)
WebUI.delay(1)

//Eliminamos los asientos del cierre y apertura
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Borrar asientos proceso de cierre y apertura'), null)
WebUI.delay(1)

//Eliminamos los asientos del mes siguiente
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Cierre y apertura/Borrar asientos mes siguiente'), null)
WebUI.delay(1)

//Fin del test
KWU.markPassed('Test finalizado con exito')
WebUI.delay(2)

WebUI.closeBrowser()
