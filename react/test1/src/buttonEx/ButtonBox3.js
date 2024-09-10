import './ButtonBox3.css';
/*
Button 컴포넌트를 만들어서 다양한 버튼을 생성할 수 있게 작성하세요.
다양한 버튼
	- 버튼 문구
	- 버튼 모양
	- type
*/

function ButtonBox3(){
	let style = {
		color : "red",
		"font-size" : "24px"
	}
	return(
		<div>
			<form>
				<div>
					<input type="text" name="test" />
				</div>
			<button text={"전송"} type={"submit"} classNames={"btn br-5"}/>
			<button text={"버튼2"} type={"button"} classNames={"btn"} style={style}/>
			<button text={"버튼3"} type={"reset"} classNames={"btn"}/>
			</form>
		</div>
	)
}
function Button(text, type, classNames, style){
	return(
		<button type={type} className={classNames} style={style}>{text}</button>
	)
}


export default ButtonBox3;