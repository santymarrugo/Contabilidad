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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import java.io.File
import java.util.Date
import java.time.LocalDateTime
import java.util.Calendar
import java.lang.Float as Float


//Iniciamos sesion en la plataforma Conty
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Plan de Cuentas'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

//Se crear estos clousers para optimizar el codigo y no repetirlo a lo largo del test
_guadarPlanExitoso = {
	//Guardamos la creacion de la nueva cuenta
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Inicio', false)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonIzquierdoCuentas'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Plan de cuentas', false)
	WebUI.delay(1)
}
_borrarLinea = {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
	WebUI.delay(1)
}
_verificarCeldaAgregada = {
	//Nos ubicamos nuevamente en la celda numero 1
	WebUI.executeJavaScript('hot.selectCell(0,1)', null)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonNuevaLinea'))
	WebUI.delay(1)
	def String filaCodCuenta = WebUI.executeJavaScript('return hot.getSelected()', null)
	println(filaCodCuenta)
	assert filaCodCuenta == '[[1, 1, 1, 1]]'
	WebUI.delay(1)
}

//ID 10,11 y 12
println("<------ ID 10, 11 y 12 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
WebUI.executeJavaScript('hot.setDataAtCell(1,1,"11118")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,2,"PRUEBA ID 10,11 y 12")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,3,"9")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(1,3)', null)
WebUI.delay(1)
def String monedaBase = WebUI.executeJavaScript('return hot.getValue(1,3)', null)
println(monedaBase)
//Validamos que en realidad la celda del Moneda base este vacia, en ese caso devuelve un null
assert monedaBase == ''
_borrarLinea.call()
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()
WebUI.delay(1)
WebUI.executeJavaScript("alert('******** AQUI TERMINA EL TEST ********')", null)
WebUI.delay(3)
WebUI.closeBrowser()