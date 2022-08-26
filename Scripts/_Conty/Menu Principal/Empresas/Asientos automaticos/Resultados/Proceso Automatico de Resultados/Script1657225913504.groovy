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
 * Fecha creacion : 7-7-2022
 * QA : Santiago Marrugo
 */

//Iniciamos sesion en la plataforma e ingresamos a la opcion Asientos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Asientos'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

//Creamos el asiento
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/Compartidos Core/Crear Asiento Proceso de Resultado'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

//Accedemos a la opcion Resultados
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabEmpresa'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientosAutomaticos'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabAsientosAutomaticosResultados'))
WebUI.delay(2)
//Verificamos que estemos en la ventana de Resultados
WebUI.verifyTextPresent('Resultados', false)
WebUI.verifyTextPresent('Resultados del ejercicio:', false)

//Entramos a correr el proceso automatico
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/Compartidos Core/Generar Resultados'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

//Se verifica que el proceso se haya generado correctamente
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/Compartidos Core/Verificar Generacion de Resultados'),[:], )
WebUI.delay(1)

//Eliminamos todas las lineas del asiento para efectos de la regresion
WebUI.executeJavaScript('hot.selectRows(0,18)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextNotPresent('3/2022', false)
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(1)

//Final del test
WebUI.executeJavaScript('alert("Test de Resultado teminado con EXITO")', null)
WebUI.delay(3)
WebUI.closeBrowser()
