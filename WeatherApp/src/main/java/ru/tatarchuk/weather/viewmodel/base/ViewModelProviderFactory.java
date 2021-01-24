package ru.tatarchuk.weather.viewmodel.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author tatarchukilya@gmail.com
 */
public class ViewModelProviderFactory<VM> extends ViewModelProvider.NewInstanceFactory {

    private Supplier<VM> viewModelSupplier;
    private Consumer<VM> hookConsumer;

    public ViewModelProviderFactory(@NonNull Supplier<VM> supplier) {
        this(supplier, null);
    }

    public ViewModelProviderFactory(@NonNull Supplier<VM> supplier,
                                    @Nullable Consumer<VM> consumer) {
        viewModelSupplier = supplier;
        hookConsumer = consumer;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        VM viewModel = viewModelSupplier.get();
        if (hookConsumer != null) {
            hookConsumer.accept(viewModel);
        }
        //noinspection unchecked
        return (T) viewModel;
    }
}
