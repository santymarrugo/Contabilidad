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
 * Fecha creacion : 24-06-2022
 * QA : Santiago Marrugo
 */

//Tipo de balance
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDTipoDeBalance'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'), '01/01/2022')
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/FechaInicial'))
//Importes en dos monedas
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDImportesEn'), '2', false)
WebUI.delay(1)
//Moneda uno pesos argentinos
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDMonedaUno'), '3', false)
WebUI.delay(1)
//Moneda dos Euros
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDMonedaDos'), '9', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Balances/BotonAceptarPopupBalance'))
WebUI.delay(5)

//Verificamos la generacion correcta del reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-2M-EDS-PARG-E'))
println(tituloReporte)
assert tituloReporte == 'Estado de situación'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte-Balance EDS-2M-PARG-E'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. $AR y €'

//Total activo
def String labelTotalACTIVO = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalACTIVO - Balance EDS 2M-PARG-E'))
println(labelTotalACTIVO)
//Total saldo en pesos argentinos
def String totalSaldoACTIVOPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalACTIVO_SaldoPARG'))
//Total saldo en Euros
def String totalSaldoACTIVOEur = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalACTIVO_Balance EDS-2M-PARG-SaldoEUR'))
/**
 * El valor correcto del Total Activo (totalSaldoACTIVOPARG) en $AR 1,614,577.05. BUG # 248159
 */
assert labelTotalACTIVO == 'Total ACTIVO' && totalSaldoACTIVOPARG == '1,614,565.68' && totalSaldoACTIVOEur == '13,777.88'

//Total pasivo
def String labelTotalPASIVO = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalPASIVO - Balance EDS 2M-PARG-E'))
println(labelTotalPASIVO)
//Total saldo en pesos argentinos
def String totalSaldoPASIVOPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalPASIVO_SaldoPARG'))
//Total saldo en Euros
def String totalSaldoPASIVOEur = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTotalPASIVO_Balance EDS-2M-PARG-SaldoEUR'))
/**
 * El valor correcto del Total Pasivo (totalSaldoPASIVOPARG) en $AR 290,830.87. BUG # 248159
 */
assert labelTotalPASIVO == 'Total PASIVO' && totalSaldoPASIVOPARG == '290,828.82' && totalSaldoPASIVOEur == '2,481.78'

//Verificamos el Pasivo + Patrimonio
def String labelPasivoMasPatrimonio = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPatrimonioMasPasivo Balance EDS-2M-PARG-E'))
println(labelPasivoMasPatrimonio)
def String patrimonioMasPasivoPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/PasivoMasPatrimonioPARG'))
def String patrimonioMasPasivoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/PasivoMasPatrimonioBalance-EDS-2M-PARG-EUR'))

/**
 * El valor correcto del Pasivo + Patrimonio (patrimonioMasPasivoPARG) en $AR 290,830.87. BUG # 248159
 */
assert labelPasivoMasPatrimonio == 'Pasivo + Patrimonio' && patrimonioMasPasivoPARG == '290,828.82' && patrimonioMasPasivoEUR == '2,481.78'

//Le damos formato al valor quitando las comas (,) y dejando solo el punto (.)
totalSaldoACTIVOPARG = totalSaldoACTIVOPARG.replace(',', '')
println(totalSaldoACTIVOPARG)
patrimonioMasPasivoPARG = patrimonioMasPasivoPARG.replace(',', '')
println(patrimonioMasPasivoPARG)

//Verificamos el Resultado, El RESULTADO es igual al Total ACTIVO menos (Pasivo + Patrimonio) en DOLARES
def String labelResultado = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelResultado'))
println(labelResultado)
assert labelResultado == 'Resultado'

def float f_totalSaldoACTIVOPARG = Float.parseFloat(totalSaldoACTIVOPARG)
def float f_patrimonioMasPasivoPARG = Float.parseFloat(patrimonioMasPasivoPARG)
def float ResultadoPARG = f_totalSaldoACTIVOPARG - f_patrimonioMasPasivoPARG
//Redondeamos el valor flotante porque trae muchos decimales y necesitamos solo dos
def float resultadoFinalPARG = Math.round(ResultadoPARG * 100) / 100
println(ResultadoPARG)
println(resultadoFinalPARG)

/**
 * El valor correcto del Resultado (resultadoFinalPARG) en $AR 1,323,746.18. BUG # 248159
 */
assert resultadoFinalPARG == Float.parseFloat('1323736.8')

//Le damos formato al valor quitando las comas (,) y dejando solo el punto (.)
totalSaldoACTIVOEur = totalSaldoACTIVOEur.replace(',', '')
println(totalSaldoACTIVOEur)
patrimonioMasPasivoEUR = patrimonioMasPasivoEUR.replace(',', '')
println(patrimonioMasPasivoEUR)

//Verificamos el Resultado, El RESULTADO es igual al Total ACTIVO menos (Pasivo + Patrimonio) en EUROS
def float f_totalSaldoACTIVOEur = Float.parseFloat(totalSaldoACTIVOEur)
def float f_patrimonioMasPasivoEUR = Float.parseFloat(patrimonioMasPasivoEUR)
def float ResultadoEUR = f_totalSaldoACTIVOEur - f_patrimonioMasPasivoEUR
//Redondeamos el valor flotante porque trae muchos decimales y necesitamos solo dos
def float resultadoFinalEUR = Math.round(ResultadoEUR * 100) / 100
println(ResultadoEUR)
println(resultadoFinalEUR)
assert resultadoFinalEUR == Float.parseFloat('11296.1')
