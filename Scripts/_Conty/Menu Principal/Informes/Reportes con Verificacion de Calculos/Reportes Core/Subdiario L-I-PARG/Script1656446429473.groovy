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
 * Fecha creacion : 28-06-2022
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
//La moneda peso argentino
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDMoneda'), '3', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/BotonAceptarPopupSubdiarios'))
WebUI.delay(5)

//Verificamos que se haya generado sin tener en cuenta los valores del Reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Subdiario L-I-PARG'))
println(tituloReporte)
assert tituloReporte == 'Libro de Ingresos'
WebUI.delay(1)

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte Subdiario L-I-PARG'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022 en $AR'

WebUI.verifyTextPresent('Monto $AR', false)
WebUI.delay(1)

//Verificamos las fechas de los asientos
def String diaLinea1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea1SubD L-I-PARG'))
println(diaLinea1)
def String diaLinea2 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea2SubD L-I-PARG'))
println(diaLinea2)
def String diaLinea3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea3SubD L-I-PARG'))
println(diaLinea3)

assert diaLinea1 == '11/01/22' && diaLinea2 == '11/01/22' && diaLinea3 == '11/01/22'

//Valores linea 1
def String totalPARGL1 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotal-L1-PARG-SubD-L-I-PARG'))
println(totalPARGL1)
assert totalPARGL1 == '1,614,577.05'

//Valores linea 2
def String montoPARGL2 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorMontoPARG-L2-SubD-L-I-PARG'))
println(montoPARGL2)
assert montoPARGL2 == '1,323,746.18'

//Valores linea 3
def String ivaPARGL3 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVA-L3-PARG-SubD-L-I-PARG'))
println(ivaPARGL3)
assert ivaPARGL3 == '290,830.87'

//Exento
def String exMontoPARG = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorExentoMontoPARG-SubD L-I-PARG'))
println(exMontoPARG)
/**
 * Aqui el valor debe ser 1,323,746.18 reportado en el bug # 248797
 */
assert exMontoPARG == '1,323,746.00'

def String exTotalPARG = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorExentoTotalPARG-SubD L-I-PARG'))
println(exTotalPARG)
/**
 * Aqui el valor debe ser 1,323,746.18 reportado en el bug # 248797
 */
assert exTotalPARG == '1,323,746.00'

//IVA Ventas
def String ivaVenPARG = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVAVentasPARG-SubD-L-I-PARG'))
println(ivaVenPARG)
def String ivaTotalPARG = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorIVAVentasTotalPARG-SubD-L-I-PARG'))
println(ivaTotalPARG)

assert ivaTotalPARG == '290,830.87' && ivaVenPARG == '290,830.87'

//Total General
def String totalGenMontoPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGenMontoPARG-SubD-L-I-PARG'))
println(totalGenMontoPARG)
def String totalGenIVAPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGenIVAPARG SubD-L-I-PARG'))
println(totalGenIVAPARG)
def String totalGenPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalGeneralPARG-SubD-L-I-PARG'))
println(totalGenPARG)

assert totalGenMontoPARG == '1,323,746.18' && totalGenIVAPARG == '290,830.87' && totalGenPARG == '1,614,577.05'
