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
 * Fecha creacion : 09-08-2022
 * QA : Santiago Marrugo
 */
KWU.logInfo("--- ID 3 ---")

//Funcion para simular la tecla Arrow Right
def avanzarAlaDerecha = {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
}
//Funcion para ingresar nuevamente a la opcion Monedas
def entrarMenuMoneda = {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/BotonMasMenuPrincipal'))
	WebUI.delay(0.5)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/TabCarpetas'))
	WebUI.delay(0.5)
	WebUI.click(findTestObject('_Conty/Menu Principal/Accesos a menu principal/Sub-TabConfiguracion'))
	WebUI.delay(0.5)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Accesos a menu principal/Sub-TabConfiguracionMonedas'))
	WebUI.delay(0.5)
	//Verificamos que estemos en la ventana de Monedas
	WebUI.verifyTextPresent('Monedas', false)
}
//Funcion para hacer click en boton terminar y asuvez en el boton SI del popup de errores
def monedaIncompleta = {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonTerminar'))
	WebUI.delay(0.8)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonSIpopupErrores'))
}
//Funcion para eliminar las monedas que se crearan.
def eliminarMoneda = {
	WebUI.executeJavaScript('hot.selectCell(5, 2)', null)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonEliminarMoneda'))
	WebUI.delay(0.5)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonAceptarPopUpBorrarMoneda'))
	WebUI.delay(1)
}
//Funcion para cerrar opcion de Monedas Exitosamente
def terminarMonedas = {
	//Hacemos clic en el boton terminar para validar que la moneda se haya creado exitosamente.
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonTerminar'))
	WebUI.delay(1)
	//Nos aseguramos que nos envie al inicio o Home
	WebUI.verifyTextPresent('Inicio', false)
}

//Ingresamos a la opción Monedas
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Configurar Monedas'), null)
WebUI.delay(0.5)

//Verificamos que al ingresar existan solo 4 monedas para que al final de agregar comprobemos que existan 6, esto nos indica que se crearon bien
//las dos monedas raras agregadas.
def String totalMonedasInicio = WebUI.executeJavaScript('return hot.countRows()', null)
KWU.logInfo(totalMonedasInicio)
assert totalMonedasInicio == '5'

KWU.logInfo("--- ID 14 ---")
//Nos ubicamos en la ultima fila en la columna Código
WebUI.executeJavaScript('hot.selectCell(4, 2)', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonNuevo'))
//Creamos la moneda rara
WebUI.executeJavaScript('hot.setDataAtCell(5, 2, "7")', null)
avanzarAlaDerecha.call()
WebUI.executeJavaScript('hot.setDataAtCell(5, 3, "Franco yibutiano")', null)
for(i=0; i<3; i++) {
	avanzarAlaDerecha.call()
}
WebUI.executeJavaScript('hot.setDataAtCell(5, 6, "0.01")', null)
avanzarAlaDerecha.call()
/**
 * Se reporta bug # 265505, fallo al escribir el arbitraje en una moneda rara, invierte los valores
 */
WebUI.executeJavaScript('hot.setDataAtCell(5, 7, "1 DJF = X USD")', null)
avanzarAlaDerecha.call()
WebUI.executeJavaScript('hot.setDataAtCell(5, 8, "5601")', null)
for(i=0; i<2; i++) {
	avanzarAlaDerecha.call()
}
WebUI.executeJavaScript('hot.setDataAtCell(5, 10, "4202")', null)
avanzarAlaDerecha.call()
terminarMonedas.call()

//Ingresamos nuevamente a la opcion Monedas para crearla sin redondeo, nombre, Arbitraje, Perdidas (DC) y Ganancias(DC)
KWU.logInfo("--- ID 4, 5, 6 y 10---")
entrarMenuMoneda.call()
WebUI.executeJavaScript('hot.selectCell(5, 2)', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonNuevo'))
WebUI.executeJavaScript('hot.setDataAtCell(6, 2, "6")', null)
monedaIncompleta.call()
WebUI.executeJavaScript('hot.selectCell(6, 3)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 3, "Franco guineano")', null)
for(i=0; i<3; i++) {
	avanzarAlaDerecha.call()
}
monedaIncompleta.call()
WebUI.executeJavaScript('hot.setDataAtCell(6, 6, "0.01")', null)
avanzarAlaDerecha.call()
monedaIncompleta.call()
/**
 * Se reporta bug # 265505, fallo al escribir el arbitraje en una moneda rara, invierte los valores
 */
WebUI.executeJavaScript('hot.setDataAtCell(6, 7, "1 GNF = X USD")', null)
avanzarAlaDerecha.call()
monedaIncompleta.call()
WebUI.executeJavaScript('hot.setDataAtCell(6, 8, "5601")', null)
for(i=0; i<2; i++) {
	avanzarAlaDerecha.call()
}
monedaIncompleta.call()
WebUI.executeJavaScript('hot.setDataAtCell(6, 10, "4202")', null)
avanzarAlaDerecha.call()
terminarMonedas.call()
entrarMenuMoneda.call()
def String totalMonedasFinal = WebUI.executeJavaScript('return hot.countRows()', null)
KWU.logInfo(totalMonedasFinal)
assert totalMonedasFinal == '7'

KWU.logInfo("--- ID 7, 8 y 9 ---")
//Ingresamos un codigo de moneda igual a 255, uno mayor a 255 (256) y uno por debajo de 255 (254)
WebUI.executeJavaScript('hot.selectCell(6, 2)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 2, "255")', null)
terminarMonedas.call()
entrarMenuMoneda.call()
WebUI.executeJavaScript('hot.selectCell(6, 2)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 2, "254")', null)
terminarMonedas.call()
entrarMenuMoneda.call()
WebUI.executeJavaScript('hot.selectCell(6, 2)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 2, "256")', null)
monedaIncompleta.call()
WebUI.executeJavaScript('hot.selectCell(6, 2)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 2, "8")', null)
terminarMonedas.call()
entrarMenuMoneda.call()

//Verificamos que los codigos de moneda esten organizados de formas ascendente
KWU.logInfo("--- ID 11 ---")
WebUI.executeJavaScript('hot.selectCell(6, 2)', null)
def String ordenAscCodigos = WebUI.executeJavaScript('return hot.getCopyableText(0, 2, 6, 2)', null)
KWU.logInfo(ordenAscCodigos)
assert ordenAscCodigos == "0\n1\n2\n3\n4\n6\n8"

//Verificar que no se pueda eliminar una moneda que esta vinculada con un asiento
KWU.logInfo("--- ID 12 ---")
WebUI.executeJavaScript('hot.selectCell(1, 2)', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonEliminarMoneda'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonAceptarPopUpBorrarMoneda'))
WebUI.delay(1)
WebUI.verifyTextPresent('La moneda no se puede borrar porque se encuentra asociada al menos en un asiento.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonAceptarPopupNoBorrarMoneda'))

//Se ingresa una cuenta inexistente en Perdidas y se valida que no lo permita el sistema
KWU.logInfo("--- ID 20 ---")
WebUI.executeJavaScript('hot.selectCell(6, 8)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 8, "5601222")', null)
avanzarAlaDerecha.call()
WebUI.verifyTextPresent('La cuenta de pérdidas ingresada no existe.', false)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonCerrarPopupAviso'))
WebUI.delay(1)
//Se ingresa una cuenta inexistente en Ganancias y se valida que no lo permita el sistema
KWU.logInfo("--- ID 21 ---")
WebUI.executeJavaScript('hot.selectCell(6, 10)', null)
WebUI.executeJavaScript('hot.setDataAtCell(6, 10, "4202111")', null)
avanzarAlaDerecha.call()
WebUI.verifyTextPresent('La cuenta de ganancias ingresada no existe.', false)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonCerrarPopupAviso'))

KWU.logInfo("--- ID 23, 24, 25, 26")
//Ir al siguiente registro
WebUI.executeJavaScript('hot.selectCell(0, 2)', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonSiguienteRegistro'))
def String siguienteRegistro = WebUI.executeJavaScript('return hot.getValue()', null)
assert siguienteRegistro == "1"
//Ir al anterior registro
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonAnteriorRegistro'))
def String anteriorRegistro = WebUI.executeJavaScript('return hot.getValue()', null)
assert anteriorRegistro == "0"
//Ir al ultimo registro
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonUltimoRegistro'))
def String ultimoRegistro = WebUI.executeJavaScript('return hot.getValue()', null)
assert ultimoRegistro == "8"
//Ir al primer registro
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonPrimerRegistro'))
def String primerRegistro = WebUI.executeJavaScript('return hot.getValue()', null)
assert primerRegistro == "0"

KWU.logInfo("--- ID 13 ---")
//Procedemos a eliminar las monedas creadas para que queden las 5 que estaban al ppio, ya que estas se usan para otros test automatizados
for(i=0; i<2; i++) {
	eliminarMoneda.call()
}
//Verificamos que se hayan eliminado las monedas
def String totalMonedasCierre = WebUI.executeJavaScript('return hot.countRows()', null)
KWU.logInfo(totalMonedasCierre)
assert totalMonedasCierre == '5'
//Salimos de la opcion Monedas
terminarMonedas.call()
KWU.markPassed('Test Terminado con Exito')
WebUI.closeBrowser()
