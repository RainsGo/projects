
import TWEEN from '@tweenjs/tween.js'

export function actionTweenedColor (controlledColor, toColor, timeMS) {
    var animationFrame

    function animate (time) {
        TWEEN.update(time)
        animationFrame = requestAnimationFrame(animate)
    }

    new TWEEN.Tween(controlledColor)
        .to(toColor, timeMS)
        .onComplete(function () {
            cancelAnimationFrame(animationFrame)
        })
        .start()
    animationFrame = requestAnimationFrame(animate)
}

export function actionTweenedNumber (objectNumber, newValue, oldValue, timeMS) {
    var animationFrame
    function animate () {
        if (TWEEN.update()) {
            animationFrame = requestAnimationFrame(animate)
        }
    }
    new TWEEN.Tween({ tweeningNumber: oldValue })
        .easing(TWEEN.Easing.Quadratic.Out)
        .to({ tweeningNumber: newValue }, timeMS)
        .onUpdate(function () {
            // console.log('animatedNumber: ', animatedNumber)
            objectNumber.number = this.tweeningNumber.toFixed(0)
        })
        .onComplete(function () {
            // console.log('animatedNumber2: ', objectNumber.number)
            cancelAnimationFrame(animationFrame)
        })
        .start()
    animationFrame = requestAnimationFrame(animate)
}
