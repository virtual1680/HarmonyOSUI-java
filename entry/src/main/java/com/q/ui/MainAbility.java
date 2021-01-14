package com.q.ui;

import com.q.ui.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        /*
         * 当系统首次创建Page实例时，触发该回调。对于一个Page实例，该回调在其生命周期过程中仅触发一次，
         * Page在该逻辑后将进入INACTIVE状态。开发者必须重写该方法，并在此配置默认展示的AbilitySlice。
         * */
    }

    @Override
    protected void onActive() {
        super.onActive();
        /*
         * Page会在进入INACTIVE状态后来到前台，然后系统调用此回调。Page在此之后进入ACTIVE状态，该状态是应用与用户交互的状态。
         * Page将保持在此状态，除非某类事件发生导致Page失去焦点，比如用户点击返回键或导航到其他Page。
         * 当此类事件发生时，会触发Page回到INACTIVE状态，系统将调用onInactive()回调。此后，Page可能重新回到ACTIVE状态，
         * 系统将再次调用onActive()回调。因此，开发者通常需要成对实现onActive()和onInactive()，
         * 并在onActive()中获取在onInactive()中被释放的资源
         * */
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        /*
        * 当Page失去焦点时，系统将调用此回调，此后Page进入INACTIVE状态。开发者可以在此回调中实现Page失去焦点时应表现的恰当行为。
        * */
    }

    @Override
    protected void onBackground() {
        super.onBackground();
        /*
        * 如果Page不再对用户可见，系统将调用此回调通知开发者用户进行相应的资源释放，此后Page进入BACKGROUND状态。
        * 开发者应该在此回调中释放Page不可见时无用的资源，或在此回调中执行较为耗时的状态保存操作。
        * */
    }

    @Override
    protected void onForeground(Intent intent) {
        super.onForeground(intent);
        /*
        * 处于BACKGROUND状态的Page仍然驻留在内存中，当重新回到前台时（比如用户重新导航到此Page），系统将先调用onForeground()回调通知开发者，
        * 而后Page的生命周期状态回到INACTIVE状态。开发者应当在此回调中重新申请在onBackground()中释放的资源，
        * 最后Page的生命周期状态进一步回到ACTIVE状态，系统将通过onActive()回调通知开发者用户。
        * */
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*
        * 系统将要销毁Page时，将会触发此回调函数，通知用户进行系统资源的释放。销毁Page的可能原因包括以下几个方面：
        * 1.用户通过系统管理能力关闭指定Page，例如使用任务管理器关闭Page。
        * 2.用户行为触发Page的terminateAbility()方法调用，例如使用应用的退出功能。
        * 3.配置变更导致系统暂时销毁Page并重建。
        * 4.系统出于资源管理目的，自动触发对处于BACKGROUND状态Page的销毁。
        * */
    }




    /*
    * Page与AbilitySlice生命周期关联:
    * 当AbilitySlice处于前台且具有焦点时，其生命周期状态随着所属Page的生命周期状态的变化而变化。当一个Page拥有多个AbilitySlice时，
    * 例如：MyAbility下有FooAbilitySlice和BarAbilitySlice，当前FooAbilitySlice处于前台并获得焦点，并即将导航到BarAbilitySlice，
    * 在此期间的生命周期状态变化顺序为：
    *   1.FooAbilitySlice从ACTIVE状态变为INACTIVE状态。
    *   2.BarAbilitySlice则从INITIAL状态首先变为INACTIVE状态，然后变为ACTIVE状态（假定此前BarAbilitySlice未曾启动）。
    *   3.FooAbilitySlice从INACTIVE状态变为BACKGROUND状态。
    *
    * 对应两个slice的生命周期方法回调顺序为：
    * FooAbilitySlice.onInactive() --> BarAbilitySlice.onStart() --> BarAbilitySlice.onActive() --> FooAbilitySlice.onBackground()
    * 在整个流程中，MyAbility始终处于ACTIVE状态。但是，当Page被系统销毁时，其所有已实例化的AbilitySlice将联动销毁，而不仅是处于前台的AbilitySlice。
    * */
}
