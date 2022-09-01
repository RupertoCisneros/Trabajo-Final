import { Component, HostBinding, Input, OnInit } from '@angular/core';
import { NavItem } from '@core/models/nav-item.model';
import { Router } from '@angular/router';
import { NavService } from '../nav.service';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css'],
    animations: [
        trigger('indicatorRotate', [
            state('collapsed', style({ transform: 'rotate(0deg)' })),
            state('expanded', style({ transform: 'rotate(180deg)' })),
            transition('expanded <=> collapsed',
                animate('225ms cubic-bezier(0.4,0.0,0.2,1)')
            ),
        ])
    ]
})
export class MenuComponent implements OnInit {

    expanded = true;

    @HostBinding('attr.aria-expanded') ariaExpanded = this.expanded;
    @Input() item!: NavItem;
    @Input() depth!: number;

    constructor(
        public navService: NavService,
        public router: Router,
    ) {
        if (this.depth === undefined) {
            this.depth = 0;
        }
    }

    ngOnInit(): void {
        this.navService.getCurrentUrl().subscribe((url: string) => {
            if (this.item.ruta) {
                this.expanded = url.indexOf(`/${this.item.ruta}`) === 0;
                this.ariaExpanded = this.expanded;
            }
        });
    }

    onItemSelected(item: NavItem): void {
        if (!item.hijos || !item.hijos.length) {
            if (item.ruta) {
                this.router.navigate([item.ruta]);
            }
        }

        if (item.hijos && item.hijos.length) {
            this.expanded = !this.expanded;
        }
    }

}
