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
 * Fecha creacion : 09-05-2022
 * QA : Santiago Marrugo
 * Descripcion : Caso para accesar a la opcion Resultados
 */

//Inicio de sesion exitoso
WebUI.callTestCase(findTestCase('_Conty/Login/Ingreso con usuario valido'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)
//Accesamos a la opcion Resultados
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabEmpresa'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientosAutomaticos'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientosAutomaticosResultados'))
WebUI.delay(2)
//Verificamos que estemos en la ventana de Diferencia de Cambio
WebUI.verifyTextPresent('Resultados', false)