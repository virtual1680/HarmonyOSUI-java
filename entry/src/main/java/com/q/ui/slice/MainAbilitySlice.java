package com.q.ui.slice;

import com.q.ui.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public class MainAbilitySlice extends AbilitySlice {

    /*
    * AbilitySlice作为Page的组成单元，其生命周期是依托于其所属Page生命周期的。
    * AbilitySlice和Page具有相同的生命周期状态和同名的回调，当Page生命周期发生变化时，它的AbilitySlice也会发生相同的生命周期变化。
    * 此外，AbilitySlice还具有独立于Page的生命周期变化，这发生在同一Page中的AbilitySlice之间导航时，此时Page的生命周期状态不会改变。
    * AbilitySlice生命周期回调与Page的相应回调类似，因此不再赘述。由于AbilitySlice承载具体的页面，开发者必须重写AbilitySlice的onStart()回调，
    * 并在此方法中通过setUIContent()方法设置页面
    *
    * AbilitySlice实例创建和管理通常由应用负责，系统仅在特定情况下会创建AbilitySlice实例。
    * 例如，通过导航启动某个AbilitySlice时，是由系统负责实例化；但是在同一个Page中不同的AbilitySlice间导航时则由应用负责实例化。
    *
    * */
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
