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
 * Fecha creacion : 21-06-2022
 * QA : Santiago Marrugo
 */

//Seleccionamos el libro
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDLibro'), '3', false)
WebUI.delay(1)
//Las fechas
//Inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), '31/01/2022')
WebUI.delay(1)
//Ubicamos el foco nuevamente en la fecha inicial para que se active el boton Aceptar
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
//La moneda euros
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDMoneda'), '9', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/BotonAceptarPopupSubdiarios'))
WebUI.delay(5)

//Verificamos que se haya generado sin tener en cuenta los valores del Reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Subdiario L-I-E'))
println(tituloReporte)
assert tituloReporte == 'Libro de Ingresos'
WebUI.delay(1)

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte Subdiario L-I-E'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022 en €'

WebUI.verifyTextPresent('Monto €', false)
WebUI.delay(1)

//Verificamos las fechas de los asientos
def String diaLinea1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea1SubD L-I-E'))
println(diaLinea1)
def String diaLinea2 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea2SubD L-I-E'))
println(diaLinea2)
def String diaLinea3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea3SubD L-I-E'))
println(diaLinea3)

assert diaLinea1 == '05/01/22' && diaLinea2 == '05/01/22' && diaLinea3 == '05/01/22'

//Valores linea 1
def String totalEURL1 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotal-L1-EUR-SubD-L-I-E'))
println(totalEURL1)
assert totalEURL1 == '309.23'

//Valores linea 2
def String montoEURL2 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorMontoEUR-L2-SubD-L-I-E'))
println(montoEURL2)
assert montoEURL2 == '253.53'

//Valores linea 3
def String ivaEURL3 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVA-L3-EUR-SubD-L-I-E'))
println(ivaEURL3)
assert ivaEURL3 == '55.70'

//Exento
def String exMontoEUR = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorExentoMontoEUR-SubD L-I-E'))
println(exMontoEUR)
assert exMontoEUR == '254.00'//Aqui el valor debe ser 253.53 reportado en el bug # 246453

def String exTotalEUR = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorExentoTotalEUR-SubD L-I-E'))
println(exTotalEUR)
assert exTotalEUR == '254.00'//Aqui el valor debe ser 253.53 reportado en el bug # 246453

//IVA Ventas
def String ivaVenEUR = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVAVentasEUR-SubD-L-I-E'))
println(ivaVenEUR)
def String ivaTotalEUR = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVAVentasTotalEUR-SubD-L-I-E'))
println(ivaTotalEUR)

assert ivaTotalEUR == '55.70' && ivaVenEUR == '55.70'

//Total General
def String totalGenMontoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGenMontoEUR-SubD-L-I-E'))
println(totalGenMontoEUR)
def String totalGenIVAEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGenIVAEUR SubD-L-I-E'))
println(totalGenIVAEUR)
def String totalGenEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGeneralEUR-SubD-L-I-E'))
println(totalGenEUR)

assert totalGenMontoEUR == '253.53' && totalGenIVAEUR == '55.70' && totalGenEUR == '309.23'
