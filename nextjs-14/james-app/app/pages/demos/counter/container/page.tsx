import { decrease, increase } from "@/lib/features/counter/counterReducer"
import { useCallback } from "react"
import { useDispatch } from "react-redux"
import { useSelector } from "react-redux"
import Counter from "../page"

const CounterContainer = () => {
    const count = useSelector((state:any) => (state.counterReducer.count))
    const dispatch = useDispatch()
    const handleClickPlus = useCallback(()=>dispatch(increase()),[dispatch])
    const handleClickMinus = useCallback(()=>dispatch(decrease()),[dispatch])

    return(<>


    </>);
}
export default CounterContainer