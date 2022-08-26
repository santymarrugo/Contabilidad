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
 * Fecha creacion : 08-04-2022
 * QA : Santiago Marrugo
 * Descripcion : Caso para accesar a la opcion Asientos del Menu Principal
 */

//Inicio de sesion exitoso
WebUI.callTestCase(findTestCase('_Conty/Login/Ingreso con usuario valido'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)
//Accesamos a la opcion Asientos
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabCarpetas'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientos'))
WebUI.delay(2)
//Verificamos que estemos en la ventana de Asientos
WebUI.verifyTextPresent('Asientos - Selección', false)