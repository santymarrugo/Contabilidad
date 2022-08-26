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
 * Fecha creacion : 19-05-2022
 * QA : Santiago Marrugo
 */

//Accedemos a la opcion Subdiarios
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Informes/Accesos a Informes/Subdiarios'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
//Seleccionamos el libro
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDLibro'), '4', false)
WebUI.delay(1)
//Las fechas
//Inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), '01/05/2022')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/Dia1Mayo'))
WebUI.delay(1)
//Final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), '31/05/2022')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/Dia31Mayo'))
WebUI.delay(1)
//La moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDMoneda'), '2', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/BotonAceptarPopupSubdiarios'))
WebUI.delay(5)
//Verificamos que se haya generado sin tener en cuenta los valores del Reporte
def String tituloReporte = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Subdiarios/LabelTituloReporteLC'))
println(tituloReporte)
assert tituloReporte == 'Libro de Ventas'
WebUI.delay(1)

def String periodoReporte = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Subdiarios/LabelPeriodoReporteLC'))
println(periodoReporte)
assert periodoReporte == '01/05/2022 a 31/05/2022 en U$S'

WebUI.verifyTextPresent('Monto U$S', false)
WebUI.delay(1)

WebUI.executeJavaScript("alert('Reporte Generado con Exito')", null)
WebUI.delay(3)

WebUI.closeBrowser()