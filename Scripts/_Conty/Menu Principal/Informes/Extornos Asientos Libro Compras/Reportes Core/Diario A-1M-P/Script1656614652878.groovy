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
 * Fecha creacion : 30-06-2022
 * QA : Santiago Marrugo
 */

//Seleccionamos el tipo de diario
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDTipoDiario'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), '01/02/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), '28/02/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'))
WebUI.delay(1)
//Importes en una moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDImportesEn'), '1', false)
WebUI.delay(1)
//Moneda pesos
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaUno'), '1', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDApertura'), '0', false)
WebUI.delay(1)
//Orden
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDOrden'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/BotonAceptarPopupDiarios'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)

//Verificamos que el reporte se haya generado, sin tener en cuenta los valores del mismo
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/LabelTituloReporte Diario A-1M-P'))
println(tituloReporte)
assert tituloReporte == 'Diario analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/LabelPeriodoReporte Diario A-1M-P'))
println(periodoReporte)
assert periodoReporte == '01/02/2022 a 28/02/2022. $'

WebUI.verifyTextPresent('Debe $', false)

//Verificar los valores
def String debePesosTransporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/DebePesosTransporte'))
println(debePesosTransporte)
def String haberPesosTransporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/HaberPesosTransporte'))
println(haberPesosTransporte)

assert debePesosTransporte == '0.00' && haberPesosTransporte == '0.00'

WebUI.verifyTextPresent('05/02/2022', false)
WebUI.verifyTextPresent('08/02/2022', false)
WebUI.verifyTextPresent('09/02/2022', false)
WebUI.verifyTextPresent('10/02/2022', false)

def String sumaAsiento1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/SumaAsiento1'))
println(sumaAsiento1) 
def String sumaAsiento2 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/SumaAsiento2'))
println(sumaAsiento2)
def String sumaAsiento3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/SumaAsiento3'))
println(sumaAsiento3)
def String sumaAsiento4 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/SumaAsiento4'))
println(sumaAsiento4)

assert sumaAsiento1 == '2,500.00' && sumaAsiento2 == '1,000.00' && sumaAsiento3 == '5,000.00' && sumaAsiento4 == '800.00'

def String totalDebe = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/TotalDebe'))
println(totalDebe)
def String totalHaber = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Diario/TotalHaber'))
println(totalHaber)

assert totalDebe == '9,300.00' && totalHaber == '9,300.00'

