package kisslinux.memento.status;

import java.util.Map;

/**
 * 多状态 备忘录角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 16:02
 */
public class MementoStatusMemento {
    // 接收Map作为状态
    private Map<String, Object> stateMap;

    // 接受一个对象，建立一个备份
    public MementoStatusMemento(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }

    public Map<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}
