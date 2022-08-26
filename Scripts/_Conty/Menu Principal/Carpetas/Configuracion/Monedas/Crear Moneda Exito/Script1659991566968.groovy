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
 * Fecha creacion : 08-08-2022
 * QA : Santiago Marrugo
 */
//Funcion para simular avanzar hacia la derecha
def avanzarAlaDerecha = {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
//Funcion para eliminar las monedas que se crearan.
def eliminarMoneda = {
	WebUI.executeJavaScript('hot.selectCell(5, 2)', null)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonEliminarMoneda'))
	WebUI.delay(0.5)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonAceptarPopUpBorrarMoneda'))
	WebUI.delay(1)
}
KWU.logInfo("--- ID 1 ---")
//Ingresamos a la opcion Monedas.
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Configurar Monedas'),[:], null)
WebUI.delay(0.1)
//Nos vamos hasta la ultima fila del listado que exista de monedas, y nos ubicamo en la columna Codigo
WebUI.executeJavaScript('hot.selectCell(4, 2)', null)
WebUI.delay(0.1)
//Agregamos una nueva linea para crear una nueva Moneda
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonNuevo'))
WebUI.delay(0.1)
//Agregamos los datos a la fila de la nueva Moneda.
WebUI.executeJavaScript('hot.setDataAtCell(5, 2, "5")', null)
avanzarAlaDerecha.call()
WebUI.executeJavaScript('hot.setDataAtCell(5, 3, "Peso colombiano")', null)
for(i=0; i<3; i++) {
	avanzarAlaDerecha.call()
}
WebUI.executeJavaScript('hot.setDataAtCell(5, 6, "0.01")', null)
for(i=0; i<2; i++) {
	avanzarAlaDerecha.call()
}
WebUI.executeJavaScript('hot.setDataAtCell(5, 8, "5601")', null)
for(i=0; i<2; i++) {
	avanzarAlaDerecha.call()
}
WebUI.executeJavaScript('hot.setDataAtCell(5, 10, "4202")', null)
avanzarAlaDerecha.call()
//Presionamos el boton terminar para validar que la moneda este bien creada
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonTerminar'))
WebUI.delay(0.5)
KWU.logInfo("--- ID 13 ---")
//Verificamos que al terminar de crear la moneda, la plataforma nos envie el Inicio o Home
WebUI.verifyTextPresent('Inicio', false)

//Accesamos a la opcion Monedas para crear una nueva moneda BCU utilizando la combinacion de teclas shift + F12
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabCarpetas'))
WebUI.delay(1)
WebUI.click(findTestObject('_Conty/Menu Principal/Accesos a menu principal/Sub-TabConfiguracion'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabConfiguracionMonedas'))
WebUI.delay(1)
//Verificamos que estemos en la ventana de Monedas
WebUI.verifyTextPresent('Monedas', false)

/**
 * Esta parte tiene un bug # 264002
 */
//KWU.logInfo("--- ID 2 ---")
////Agregamos una nueva linea para crear una nueva Moneda
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonNuevo'))
//WebUI.delay(0.1)
////Agregamos los datos a la fila de la nueva Moneda.
//WebUI.executeJavaScript('hot.setDataAtCell(1, 2, "6")', null)
//avanzarAlaDerecha.call()
//WebUI.executeJavaScript('hot.setDataAtCell(1, 3, "Peso chileno")', null)
//for(i=0; i<3; i++) {
//	avanzarAlaDerecha.call()
//}
//WebUI.executeJavaScript('hot.setDataAtCell(1, 6, "0.01")', null)
//for(i=0; i<2; i++) {
//	avanzarAlaDerecha.call()
//}
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.F12))

//Eliminamos las monedas que se crearon
eliminarMoneda.call()
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonTerminar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Inicio', false)

KWU.markPassed("Test Terminado con extio")

