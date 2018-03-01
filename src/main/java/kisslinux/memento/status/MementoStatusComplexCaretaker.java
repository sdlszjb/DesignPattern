package kisslinux.memento.status;

import java.util.HashMap;
import java.util.Map;

/**
 * 支持多备份点的 备份管理类
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 19:25
 */
public class MementoStatusComplexCaretaker {
    // 容纳备忘录的容器
    private Map<String, MementoStatusMemento> mementoMap = new HashMap<>();
    public MementoStatusMemento getMemento(String idx) {
        return mementoMap.get(idx);
    }

    public void setMementoMap(String idx, MementoStatusMemento memento) {
        this.mementoMap.put(idx, memento);
    }
}
